package gregapi.stubs;

import net.minecraft.world.item.ItemStack;

// PHASE7: OreDict registration events replaced by Tag system in 1.21.
// Stub keeps compilation; real implementation deferred to Phase 7.
@SuppressWarnings("unused")
public class OreRegisterEvent {
	public final String Name;
	public final ItemStack Ore;

	public OreRegisterEvent(String name, ItemStack ore) {
		this.Name = name;
		this.Ore = ore;
	}

	public String getName() { return Name; }
	public ItemStack getOre() { return Ore; }
}
