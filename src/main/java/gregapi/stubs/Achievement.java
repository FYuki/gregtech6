package gregapi.stubs;

// PHASE3: Achievement system replaced by Advancements in MC 1.12+.
// Stub for compilation; will be migrated to AdvancementHolder in Phase 3.
@SuppressWarnings("unused")
public class Achievement {
	public final String statId;
	public Achievement(String id, String name, int x, int y, Object icon, Achievement parent) { this.statId = id; }
	public Achievement registerStat() { return this; }
}
