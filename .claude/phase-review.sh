#!/usr/bin/env bash
# Phase-end review script for GT6 migration
# Triggered after a git commit on a phase/* branch.
# Prints a summary of what changed and flags known issues.

set -euo pipefail

REPO_ROOT="$(git -C "$(dirname "$0")/.." rev-parse --show-toplevel)"
cd "$REPO_ROOT"

BRANCH="$(git branch --show-current)"
LAST_COMMIT="$(git log -1 --format='%H %s')"
PHASE_TAG="${BRANCH%%/*}"   # "phase" if branch is phase/N-name

if [[ "$BRANCH" != phase/* ]]; then
    exit 0   # Not a phase branch — skip
fi

echo ""
echo "========================================================"
echo "  GT6 Migration — Phase-End Review"
echo "  Branch : $BRANCH"
echo "  Commit : $LAST_COMMIT"
echo "========================================================"

# ── Files changed in last commit ─────────────────────────────
CHANGED=$(git diff-tree --no-commit-id -r --name-only HEAD)
FILE_COUNT=$(echo "$CHANGED" | wc -l)
echo ""
echo "── Files changed in this commit: $FILE_COUNT"
echo "$CHANGED" | sed 's/^/   /'

# ── TODO tag counts ───────────────────────────────────────────
echo ""
echo "── Outstanding TODO tags in changed files:"
for TAG in PHASE3 PHASE4 PHASE5 PHASE6 PHASE7 PHASE8; do
    COUNT=$(grep -r "// $TAG:" src/main/java/ --include="*.java" -l 2>/dev/null | wc -l)
    if [ "$COUNT" -gt 0 ]; then
        echo "   $TAG: $COUNT file(s) contain deferred work"
    fi
done

# ── Leftover old-API patterns to review ──────────────────────
echo ""
echo "── Scan for residual 1.7.10 API patterns in changed files:"
ISSUES=0
for F in $CHANGED; do
    [ -f "$F" ] || continue
    if grep -qE "cpw\.mods\.fml\." "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still has cpw.mods.fml import"
        ISSUES=$((ISSUES+1))
    fi
    if grep -qE "net\.minecraftforge\.(fml|common|event)\." "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still has net.minecraftforge import"
        ISSUES=$((ISSUES+1))
    fi
    if grep -qE "\b(xCoord|yCoord|zCoord|worldObj)\b" "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still uses old TE coordinate fields (xCoord/yCoord/zCoord/worldObj)"
        ISSUES=$((ISSUES+1))
    fi
    if grep -qE "getBlockMetadata|setBlockMetadataWithNotify" "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still uses block metadata API"
        ISSUES=$((ISSUES+1))
    fi
    if grep -qE "IBlockAccess(?!.*//)" "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still uses IBlockAccess (should be BlockGetter)"
        ISSUES=$((ISSUES+1))
    fi
    if grep -qE "getTagCompound|setTagCompound|hasKey\(" "$F" 2>/dev/null; then
        echo "   ⚠ $F  — still uses old NBT ItemStack API"
        ISSUES=$((ISSUES+1))
    fi
done

if [ "$ISSUES" -eq 0 ]; then
    echo "   ✓ No obvious residual patterns found in changed files."
fi

# ── Summary ───────────────────────────────────────────────────
echo ""
echo "── Next steps:"
case "$BRANCH" in
    phase/1-*)
        echo "   → Run: ./gradlew compileJava (locally)"
        echo "   → Verify neoforge.mods.toml is valid"
        ;;
    phase/2-*)
        echo "   → Run: ./gradlew compileJava (locally)"
        echo "   → Check: NetworkHandler.registerPayloadHandlers() wired in GT_API"
        echo "   → Check: mod/game bus separation (mod bus = FMLCommonSetupEvent etc)"
        ;;
    phase/3-*)
        echo "   → Run: ./gradlew build"
        echo "   → In-game: verify blocks/items appear in Creative tab"
        ;;
    phase/4-*)
        echo "   → Run: ./gradlew build"
        echo "   → In-game: verify block and item textures render correctly"
        ;;
    phase/5-*)
        echo "   → Run: ./gradlew build"
        echo "   → In-game: generate new world, check ore/tree spawning"
        ;;
    phase/6-*)
        echo "   → Run: ./gradlew build"
        echo "   → Verify no ASM class conflicts at startup"
        ;;
    phase/7-*)
        echo "   → Run: ./gradlew build"
        echo "   → In-game: check GT recipes visible in JEI/REI"
        ;;
    phase/8-*)
        echo "   → Run: ./gradlew build"
        echo "   → In-game: test compat features for installed companion mods"
        ;;
esac
echo ""
echo "========================================================"
