package gregapi.stubs;
// PHASE4: RenderPlayerEvent stub
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.player.Player;
@SuppressWarnings("unused")
public class RenderPlayerEvent extends Event {
    public static class Pre extends RenderPlayerEvent {}
    public static class Post extends RenderPlayerEvent {}
    public static class Specials extends RenderPlayerEvent {
        public static class Pre extends Specials {}
        public static class Post extends Specials {}
    }
    public Player getPlayer() { return null; }
}
