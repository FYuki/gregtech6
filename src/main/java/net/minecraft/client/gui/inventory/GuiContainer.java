package net.minecraft.client.gui.inventory;
// PHASE4: stub — full rendering rewrite needed

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import java.util.List;
/** PHASE4: Stub for old GuiContainer — replaced by AbstractContainerScreen in 1.21 */
public abstract class GuiContainer {
    protected net.minecraft.client.Minecraft mc;
    protected Object fontRendererObj;
    protected Object inventorySlots;
    protected int guiLeft, guiTop, xSize = 176, ySize = 166;
    protected int width, height;

    protected GuiContainer(AbstractContainerMenu container) {}

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {}
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {}
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {}
    protected void drawTexturedModalRect(int x, int y, int u, int v, int w, int h) {}
    protected void drawHoveringText(List<String> lines, int x, int y, Object font) {}
    protected boolean func_146978_c(int slotX, int slotY, int w, int h, int mouseX, int mouseY) { return false; }
}
