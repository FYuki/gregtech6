package net.minecraft.client.gui;
/** PHASE4: stub — FontRenderer renamed to Font in MC 1.18+ */
public class FontRenderer {
    public int FONT_HEIGHT = 9;
    public int getStringWidth(String text) { return text.length() * 6; }
    public void drawString(String text, float x, float y, int color) {}
    public void drawString(String text, int x, int y, int color) {}
    public void drawStringWithShadow(String text, float x, float y, int color) {}
}
