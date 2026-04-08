package net.minecraft.client.audio;
// PHASE4: stub - ISound → SoundInstance in 1.21
public interface ISound {
    String getSoundLocation();
    float getVolume();
    float getPitch();
    float getXPosF();
    float getYPosF();
    float getZPosF();
    default AttenuationType getAttenuationType() { return AttenuationType.LINEAR; }

    enum AttenuationType {
        NONE, LINEAR;
    }
}
