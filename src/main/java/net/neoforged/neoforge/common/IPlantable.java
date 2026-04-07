package net.neoforged.neoforge.common;
// PHASE8: stub - IPlantable was removed in NeoForge 21.4.x; canSustainPlant uses vanilla Block callback
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.PlantType;

public interface IPlantable {
    PlantType getPlantType(BlockGetter world, BlockPos pos);
    BlockState getPlant(BlockGetter world, BlockPos pos);
}
