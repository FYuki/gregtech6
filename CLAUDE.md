## TAKTワークフロー運用ルール（最優先）

### セッション開始時に必ず実行
.takt/tasks.yamlを確認し、未完了タスクがあればユーザーに報告する。

### AI役割分担
- このClaude：設計・レビュー・指示プロンプト生成のみ
- GitHub Copilot CLI：実装・テスト・git操作・PR作成

### 禁止事項
- Claudeが実装コードを直接書くこと
- reviewステップでdiff以外のソースファイルを読むこと
- human_reviewステップをスキップすること

# GregTech 6 — NeoForge 1.21.4 Migration

## Project Overview

GregTech 6 (GT6) is being migrated from Minecraft 1.7.10 + ForgeGradle 1.2.11 to
**NeoForge 21.4.x / Minecraft 1.21.4 / Java 21**.

GregAPI (the underlying API layer, `gregapi/` package) is migrated inline in this
same repository — not as a separate project.

The canonical plan lives in [`docs/migration-plan.md`](docs/migration-plan.md).

---

## Design Principles — Must Be Preserved

| Principle | Details |
|-----------|---------|
| **Multi-Energy system** | EU, LU, QU, KU, RU, HU, CU, MU, NU, TU — all 10+ energy types as separate APIs |
| **MultiTileEntity** | 1 block class managing 30,000+ machine variants via NBT-driven registry |
| **GT6 packet/voltage model** | EU packets: voltage = packet size, amperage = parallel count |
| **Cover system** | `ICover` interceptor design; covers are not blocks, they override callbacks |
| **OreDictMaterial** | 32,767 materials keyed by short ID, not string keys |

---

## Architectural Decisions Made

### Networking (Phase 2)
- **Single `GregPacketPayload`** registered once covers all GT6 network channels.
  A `channelId` field routes to the correct `NetworkHandler` via a static `REGISTRY` map.
- Packet IDs 0-255 are still used internally per channel; no change to `IPacket` protocol.
- `registerPayloadHandlers()` must be called from the mod-bus `RegisterPayloadHandlersEvent`.
  This is wired in `GT_API` constructor.

### Mod Lifecycle (Phase 2)
- All three mod main classes (`GT_API`, `GT_API_Post`, `GT6_Main`) take `IEventBus modEventBus`
  in their constructor (NeoForge 1.21 injection pattern).
- **Mod bus** events: `FMLCommonSetupEvent`, `InterModEnqueueEvent`, `FMLLoadCompleteEvent`,
  `RegisterPayloadHandlersEvent`.
- **Game bus** events: `ServerStartingEvent`, `ServerStartedEvent`, `ServerStoppingEvent`,
  `ServerStoppedEvent`, `EntityJoinLevelEvent`, etc. — registered via `NeoForge.EVENT_BUS`.
- `@SidedProxy` is gone; replaced with `FMLEnvironment.dist.isClient()` guard.
- `LoadController` reflection hack removed; load ordering is now handled declaratively in
  `neoforge.mods.toml [[dependencies]]`.

### Config (Phase 2)
- `FMLPaths.CONFIGDIR.get().toFile()` replaces `aEvent.getModConfigurationDirectory()`.

---

## Branch / Phase Structure

| Branch | Status | Description |
|--------|--------|-------------|
| `phase/1-build-system` | ✅ merged | build.gradle, settings.gradle, neoforge.mods.toml |
| `phase/2-gregapi-core` | ✅ done, PR open | FML→NeoForge imports, lifecycle, networking |
| `phase/3-registration` | 🔜 next | DeferredRegister, BlockState, DataComponents |
| `phase/4-rendering` | 🔜 | BakedModel, TextureAtlasSprite, PoseStack |
| `phase/5-worldgen` | 🔜 | Feature/PlacedFeature/BiomeModifier |
| `phase/6-asm` | 🔜 | GT_ASM → Mixin |
| `phase/7-recipes` | 🔜 | Tags, datapack recipes, MissingMappingsEvent |
| `phase/8-compat` | 🔜 | Compatibility modules (IC2, AE2, …) |

---

## TODO Tag Conventions

Throughout the migrated code, deferred work is marked with phase tags:

| Tag | Meaning |
|-----|---------|
| `// PHASE3:` | Block/Item registration, BlockState, DataComponents |
| `// PHASE4:` | Rendering — BakedModel, BEWLR, texture stitching |
| `// PHASE5:` | World generation — ore gen, biome decoration |
| `// PHASE6:` | ASM / Mixin |
| `// PHASE7:` | Recipes, OreDict→Tag mapping |
| `// PHASE8:` | Compat module updates |

---

## Environment Notes

- **`maven.neoforged.net` is blocked** in this container (403 Forbidden from egress proxy).
  `./gradlew build` cannot download NeoForge artifacts inside this container.
  Build verification must be done outside (e.g., on the user's local machine via `./gradlew runClient`).
- **`plugins.gradle.org` is blocked** — foojay-resolver plugin is disabled in `settings.gradle`.
  Java 21 must be available via `JAVA_HOME` or `PATH`.
- Gradle wrapper version: 8.11.1 (set in `gradle/wrapper/gradle-wrapper.properties`).

---

## Key File Locations

| Path | Purpose |
|------|---------|
| `src/main/java/gregapi/` | GregAPI — 637 files, migrated inline |
| `src/main/java/gregtech/` | GT6 main code — ~591 files |
| `src/main/resources/META-INF/neoforge.mods.toml` | Mod descriptor (Phase 1) |
| `src/main/resources/META-INF/accesstransformer.cfg` | Access transformers (Phase 1) |
| `src/main/java/gregapi/network/NetworkHandler.java` | Custom payload networking (Phase 2) |
| `src/main/java/gregtech/GT6_Main.java` | GT6 main mod class (Phase 2) |
| `src/main/java/gregapi/GT_API.java` | GregAPI main mod class (Phase 2) |
| `docs/migration-plan.md` | Detailed phase plan with status |
