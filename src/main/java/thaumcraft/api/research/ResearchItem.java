package thaumcraft.api.research;
// PHASE8: stub for compat

import net.minecraft.world.item.ItemStack;
public class ResearchItem {
    public int displayColumn, displayRow;
    public java.util.Map<String,ResearchItem> research = new java.util.HashMap<>();
    public ResearchItem(String key, String category, thaumcraft.api.aspects.AspectList tags, int col, int row, int complexity, ItemStack icon) {
        this.displayColumn = col; this.displayRow = row;
    }
    public ResearchItem setParents(String... parents) { return this; }
    public ResearchItem setParentsHidden(String... parents) { return this; }
    public ResearchItem setHidden() { return this; }
    public ResearchItem setConcealed() { return this; }
    public ResearchItem setSpecial() { return this; }
    public ResearchItem setSecondary() { return this; }
    public ResearchItem registerResearchItem() { return this; }
}
