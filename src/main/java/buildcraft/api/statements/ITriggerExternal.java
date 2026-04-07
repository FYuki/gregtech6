package buildcraft.api.statements;
// PHASE8: stub for compat
public interface ITriggerExternal extends IStatement { java.util.Collection<net.minecraft.core.Direction> getPossibleSides(net.minecraft.world.level.block.entity.BlockEntity tile); boolean isTriggerActive(net.minecraft.world.level.block.entity.BlockEntity tile, net.minecraft.core.Direction side, IStatementContainer container, IStatementParameter[] parameters); }
