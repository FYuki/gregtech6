package gregapi.stubs;
// PHASE4: stub - TextureStitchEvent → TextureAtlasStitchedEvent in NeoForge 1.21
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.neoforged.bus.api.Event;
public class TextureStitchEvent extends Event {
    private final TextureAtlas atlas;
    public TextureStitchEvent(TextureAtlas atlas) { this.atlas = atlas; }
    public TextureAtlas getAtlas() { return atlas; }
    public static class Pre extends TextureStitchEvent {
        public Pre(TextureAtlas atlas) { super(atlas); }
    }
    public static class Post extends TextureStitchEvent {
        public Post(TextureAtlas atlas) { super(atlas); }
    }
}
