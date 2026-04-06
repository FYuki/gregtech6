package gregapi.stubs;
// PHASE4: ClientTickEvent — use LevelTickEvent or TickEvent in NeoForge 1.21
import net.neoforged.bus.api.Event;
@SuppressWarnings("unused")
public class ClientTickEvent extends Event {
    public enum Phase { START, END }
    public Phase phase = Phase.START;
}
