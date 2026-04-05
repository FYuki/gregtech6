# GregTech 6 → NeoForge 1.21.4 Migration Plan

## Status Overview

| Phase | Branch | Status | Description |
|-------|--------|--------|-------------|
| 1 | `phase/1-build-system` | ✅ **Done** | Build system: Gradle 8, NeoForge Gradle 7, neoforge.mods.toml |
| 2 | `phase/2-gregapi-core` | ✅ **Done** | GregAPI core: FML→NeoForge, lifecycle, networking |
| 3 | `phase/3-registration` | ⏳ Pending | Block/Item registration: DeferredRegister, BlockState, DataComponents |
| 4 | `phase/4-rendering` | ⏳ Pending | Rendering: BakedModel, TextureAtlasSprite |
| 5 | `phase/5-worldgen` | ⏳ Pending | World generation: Feature/PlacedFeature/BiomeModifier |
| 6 | `phase/6-asm` | ⏳ Pending | ASM/CoreMod → Mixin |
| 7 | `phase/7-recipes` | ⏳ Pending | Recipes: Tags, datapack JSON, MissingMappingsEvent |
| 8 | `phase/8-compat` | ⏳ Pending | Compatibility modules |

---

## Phase 1 — Build System ✅

**Branch:** `phase/1-build-system`  
**Commit:** `59046fe`

### Changes Made
- `build.gradle` — Complete rewrite for NeoForge Gradle 7.x
  - `net.neoforged.gradle.userdev` plugin
  - Minecraft 1.21.4 + NeoForge 21.4.x
  - Java 21 toolchain
- `settings.gradle` — Removed foojay-resolver (blocked); NeoForge maven added
- `gradle/wrapper/gradle-wrapper.properties` — Gradle 8.11.1
- `src/main/resources/META-INF/neoforge.mods.toml` — New mod descriptor
  - Declares both `gregapi` and `gregtech` mods with dependency ordering
- `src/main/resources/META-INF/accesstransformer.cfg` — Converted from `gregtech_at.cfg`
- `src/main/resources/pack.mcmeta` — Resource pack declaration (pack_format 34)

### Environment Limitation
`maven.neoforged.net` returns 403 in this container. `./gradlew build` cannot run here.
User must verify builds locally via `./gradlew runClient`.

---

## Phase 2 — GregAPI Core Framework ✅

**Branch:** `phase/2-gregapi-core`  
**Commits:** `631dc2e`, `cbd344c`

### Changes Made

#### Commit 1 — Framework Core (12 files)

| File | Change |
|------|--------|
| `gregapi/compat/ICompat.java` | FML event types → NeoForge: `FMLCommonSetupEvent`, `InterModEnqueueEvent`, `FMLLoadCompleteEvent`, `ServerStartingEvent`, `MissingMappingsEvent<?>` |
| `gregapi/api/Abstract_Proxy.java` | All 14 proxy method signatures updated to NeoForge event types |
| `gregapi/api/Abstract_Mod.java` | Abstract/concrete lifecycle method signatures updated |
| `gregapi/network/INetworkHandler.java` | Complete rewrite: added `TargetPoint` record, `BlockPos` overloads, NeoForge types |
| `gregapi/network/IPacket.java` | `IBlockAccess` → `BlockGetter` |
| `gregapi/network/NetworkHandler.java` | Complete rewrite: `GregPacketPayload` record + `REGISTRY` routing |
| `gregtech/GT6_Main.java` | `@Mod` simplified; `IEventBus` constructor; mod/game bus wiring; `LoadController` hack removed |
| `gregtech/GT_Proxy.java` | Terrain gen stubs (PHASE5); entity event updates; `FMLCommonHandler` removed |
| `gregapi/GT_API.java` | `@Mod` simplified; `IEventBus` constructor; `NetworkHandler` payload registration |
| `gregapi/GT_API_Post.java` | Same pattern as GT_API; `LoadController` hack removed |
| `gregapi/GT_API_Proxy.java` | `IGuiHandler`/`IWorldGenerator` removed; constructor stripped |

#### Commit 2 — Batch Import Replacements (130 files)

Machine-processed replacement of:
- `cpw.mods.fml.common.*` → `net.neoforged.fml.*`
- `cpw.mods.fml.relauncher.Side` → `net.neoforged.api.distmarker.Dist`
- `cpw.mods.fml.relauncher.SideOnly` → `net.neoforged.api.distmarker.OnlyIn`
- `net.minecraftforge.common.*` → `net.neoforged.neoforge.common.*`
- `net.minecraftforge.event.*` → `net.neoforged.neoforge.event.*`
- `net.minecraftforge.fml.*` → `net.neoforged.fml.*`
- `net.minecraft.world.IBlockAccess` → `net.minecraft.world.level.BlockGetter`
- `net.minecraft.entity.player.EntityPlayer` → `net.minecraft.world.entity.player.Player`
- `net.minecraft.tileentity.TileEntity` → `net.minecraft.world.level.block.entity.BlockEntity`
- `net.minecraft.world.World` → `net.minecraft.world.level.Level`
- `net.minecraft.util.math.BlockPos` → `net.minecraft.core.BlockPos`

### Key Architectural Decisions

**Networking:** Single `GregPacketPayload` with `channelId` field covers all GT6 channels.
This avoids registering a separate `CustomPacketPayload` type per channel.

**Lifecycle:** All three mod classes (`GT_API`, `GT_API_Post`, `GT6_Main`) accept
`IEventBus modEventBus` via constructor injection (NeoForge 1.21 pattern).

**Terrain gen events:** Completely removed in NeoForge 1.21. All handlers stubbed with
`// PHASE5:` comments for reimplementation as Feature/PlacedFeature.

---

## Phase 3 — Block/Item Registration ⏳

**Target branch:** `phase/3-registration`

### Scope

#### 3-1. DeferredRegister Introduction
- Replace `GameRegistry.registerBlock/Item()` → `DeferredRegister<Block/Item>`
- Create central `GregRegistries` class holding all `DeferredRegister` instances
- Wire registers to mod bus in `GT_API` constructor

#### 3-2. Block Metadata → BlockState
- 1.13+ blocks have no metadata; all variant info must be in `BlockStateProperty`
- MultiTileEntity: 1 block + `BlockEntityType` still works (variant is in BE NBT, not block state)
- Colored blocks: `EnumProperty<DyeColor>` (16 values)
- Stone type blocks: `IntegerProperty` or per-variant block registration
- Fluid level: `BlockStateProperties.LEVEL` (0-8)

#### 3-3. ItemStack NBT → DataComponents (1.20.5+)
- `ItemStack.getTagCompound()` / `setTagCompound()` are gone
- Define `DataComponentType<T>` for each GT6 item-specific datum:
  - Charge amount (batteries, tools)
  - Material ID (material items)
  - Tool damage / electric charge
- `ItemStack.get(component)` / `ItemStack.set(component, value)`

#### 3-4. IInventory → IItemHandler Capability
- `IInventory` is no longer used as an API parameter
- Use `IItemHandler` (NeoForge capability) for external item access
- Affects: `IItemEnergy`, `MultiItem`, `GT_API_Proxy`, ~15 files

#### 3-5. MultiTileEntity Registry
- `TileEntity` → `BlockEntity`
- `readFromNBT` / `writeToNBT` → `loadAdditional` / `saveAdditional`
- `getDescriptionPacket()` → `getUpdatePacket()` + `ClientboundBlockEntityDataPacket.create()`
- `onDataPacket()` signature update

### Files Affected
- `gregtech/blocks/` — 66 files
- `gregapi/block/` — base classes
- `gregapi/block/multitileentity/MultiTileEntityRegistry.java`
- `gregtech/tileentity/` — 242 files (via base class changes)

---

## Phase 4 — Rendering ⏳

**Target branch:** `phase/4-rendering`

### Scope

The entire old rendering pipeline is gone:
`ISimpleBlockRenderingHandler` / `RenderBlocks` / `Tessellator` / `IIcon` / `IIconRegister`

#### 4-1. Block Rendering
- Implement `BakedModel` (or `IUnbakedModel` → `BakedModel`)
- `VertexConsumer` replaces `Tessellator.addVertex()`
- `PoseStack` replaces `GL11.glTranslatef()`
- `TextureAtlasSprite` replaces `IIcon`
- `TextureAtlasStitchEvent` replaces `IIconRegister`
- GT6's `ITexture` / `IRenderedBlock` interfaces preserved; internals rewritten

#### 4-2. Item Rendering
- `IItemRenderer` gone → `ItemOverrides` + `BakedModel`
- Custom-shape items: `BakedModel.isCustomRenderer()` + BEWLR

#### 4-3. Entity / BlockEntity Rendering
- `TileEntitySpecialRenderer<T>` → `BlockEntityRenderer<T>`
- `GT_Renderer_Entity_Arrow`, `PlayerModelRenderer` updated

#### 4-4. Textures
- `assets/gregtech/textures/` PNG files reused as-is
- New JSON model stubs in `assets/gregtech/models/block/` and `assets/gregtech/models/item/`

---

## Phase 5 — World Generation ⏳

**Target branch:** `phase/5-worldgen`

### Scope

All terrain gen Forge events (`OreGenEvent`, `DecorateBiomeEvent`, `PopulateChunkEvent`,
`BiomeEvent`) are gone in NeoForge 1.21.

#### 5-1. Ore Generation
- `IWorldGenerator` → `Feature<OreConfiguration>` subclass
- Register via `DeferredRegister<Feature<?>>`
- Place via `PlacedFeature` + `BiomeModifier` JSON datapack

#### 5-2. Loot Tables (ChestGenHooks)
- `ChestGenHooks` → `LootTableLoadEvent` or datapack JSON pool injection
- `gregtech/worldgen/ChestGenHooksChestReplacer.java` — complete rewrite

#### 5-3. Custom Trees (50+ types)
- `WorldGenTrees` → `TreeFeature` subclass

#### 5-4. Biome Registration
- `BiomeManager.addBiome()` → `BiomeModifier` (JSON datapack or code)

---

## Phase 6 — ASM / CoreMod → Mixin ⏳

**Target branch:** `phase/6-asm`

- `IFMLLoadingPlugin` (`GT_ASM.java`) → SpongePowered Mixin
- Each `IClassTransformer` → `@Mixin` class
- Add Mixin dependency to `build.gradle`
- `annotationProcessor 'org.spongepowered:mixin:0.8.5:processor'`

---

## Phase 7 — Recipes ⏳

**Target branch:** `phase/7-recipes`

- `OreDictionary` → `Tag<Item>` / `Tag<Block>`
- `GameRegistry.addShapedRecipe()` → `ShapedRecipeBuilder` or datapack JSON
- `MissingMappingsEvent` for registry remapping (already stubbed in Phase 2)
- GT6 internal `RecipeMap` system: **no changes needed** (pure Java logic)

---

## Phase 8 — Compatibility Modules ⏳

**Target branch:** `phase/8-compat`

- Audit `gregtech/compat/` (59 files) for which mods have 1.21.x ports
- Confirmed 1.21.x ports as of 2024: AE2, Mekanism, JEI, REI
- IC2 Classic: check if 1.21 port exists; if not, stub/disable
- Remove compat code for mods with no 1.21 port
- Update remaining compat to NeoForge Capability API

---

## Verification Checklist

| Phase | Claude verifies | User verifies in-game |
|-------|----------------|----------------------|
| 1+2 | `./gradlew compileJava` (locally) | Mod loads, main menu appears |
| 3 | Compile clean | Blocks/items in Creative tab |
| 4 | Compile clean | Textures render correctly |
| 5 | Compile clean | Ores/trees generate in new world |
| 7 | Compile clean | GT recipes in JEI/REI |
| All | `./gradlew build` | Machines, energy, multiblocks work |
