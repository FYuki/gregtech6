package gregapi.stubs;
// PHASE3: IEntitySelector replaced by Predicate<Entity> in 1.21
import net.minecraft.world.entity.Entity;
import java.util.function.Predicate;
@SuppressWarnings("unused")
public interface IEntitySelector extends Predicate<Entity> {}
