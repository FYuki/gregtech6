package net.minecraft.client.audio;
// PHASE4: stub - ITickableSound → TickableSoundInstance in 1.21
public interface ITickableSound extends ISound {
    void update();
    boolean isDonePlaying();
}
