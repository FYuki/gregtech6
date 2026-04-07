package net.minecraft.client.model;
// PHASE4: stub - ModelRenderer → ModelPart in 1.21
public class ModelRenderer {
    public float rotationPointX, rotationPointY, rotationPointZ;
    public float rotateAngleX, rotateAngleY, rotateAngleZ;
    public boolean showModel = true;
    public ModelRenderer(ModelBase model, int texOffX, int texOffY) {}
    public ModelRenderer(int texWidth, int texHeight, int texOffX, int texOffY) {}
    public void addBox(float x, float y, float z, int w, int h, int d) {}
    public void render(float scale) {}
    public void renderWithRotation(float scale) {}
    public void postRender(float scale) {}
    public ModelRenderer setRotationPoint(float x, float y, float z) { return this; }
    public ModelRenderer setTextureOffset(int x, int y) { return this; }
}
