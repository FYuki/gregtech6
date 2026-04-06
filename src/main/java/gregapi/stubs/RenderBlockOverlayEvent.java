package gregapi.stubs;
// PHASE4: RenderBlockOverlayEvent stub
import net.neoforged.bus.api.Event;
@SuppressWarnings("unused")
public class RenderBlockOverlayEvent extends Event {
    public enum OverlayType { FIRE, BLOCK, WATER }
    public OverlayType getOverlayType() { return OverlayType.BLOCK; }
}
