package gregapi.stubs;

import net.minecraft.world.effect.MobEffect;

/**
 * PHASE3: stub — old net.minecraft.potion.Potion API.
 * In MC 1.21.4, use MobEffects.* (Holder<MobEffect>) and MobEffectInstance.
 * Static fields retain legacy integer IDs for compatibility with existing GT6 code.
 */
public class Potion {
    public final int id;
    public final MobEffect effect;

    public Potion(int id, MobEffect effect) {
        this.id = id;
        this.effect = effect;
    }

    public static final Potion moveSpeed     = new Potion( 1, null);
    public static final Potion moveSlowdown  = new Potion( 2, null);
    public static final Potion digSpeed      = new Potion( 3, null);
    public static final Potion digSlowdown   = new Potion( 4, null);
    public static final Potion damageBoost   = new Potion( 5, null);
    public static final Potion heal          = new Potion( 6, null);
    public static final Potion harm          = new Potion( 7, null);
    public static final Potion jump          = new Potion( 8, null);
    public static final Potion confusion     = new Potion( 9, null);
    public static final Potion regeneration  = new Potion(10, null);
    public static final Potion resistance    = new Potion(11, null);
    public static final Potion fireResistance = new Potion(12, null);
    public static final Potion waterBreathing = new Potion(13, null);
    public static final Potion invisibility  = new Potion(14, null);
    public static final Potion blindness     = new Potion(15, null);
    public static final Potion nightVision   = new Potion(16, null);
    public static final Potion hunger        = new Potion(17, null);
    public static final Potion weakness      = new Potion(18, null);
    public static final Potion poison        = new Potion(19, null);
    public static final Potion wither        = new Potion(20, null);
    public static final Potion healthBoost   = new Potion(21, null);
    public static final Potion absorption    = new Potion(22, null);
    public static final Potion saturation    = new Potion(23, null);
    public static final Potion glowing       = new Potion(24, null);
    public static final Potion levitation    = new Potion(25, null);
    public static final Potion luckBoost     = new Potion(26, null);
    public static final Potion unluck        = new Potion(27, null);

    public static final Potion[] potionTypes;

    static {
        potionTypes = new Potion[256];
        potionTypes[ 1] = moveSpeed;
        potionTypes[ 2] = moveSlowdown;
        potionTypes[ 3] = digSpeed;
        potionTypes[ 4] = digSlowdown;
        potionTypes[ 5] = damageBoost;
        potionTypes[ 6] = heal;
        potionTypes[ 7] = harm;
        potionTypes[ 8] = jump;
        potionTypes[ 9] = confusion;
        potionTypes[10] = regeneration;
        potionTypes[11] = resistance;
        potionTypes[12] = fireResistance;
        potionTypes[13] = waterBreathing;
        potionTypes[14] = invisibility;
        potionTypes[15] = blindness;
        potionTypes[16] = nightVision;
        potionTypes[17] = hunger;
        potionTypes[18] = weakness;
        potionTypes[19] = poison;
        potionTypes[20] = wither;
        potionTypes[21] = healthBoost;
        potionTypes[22] = absorption;
        potionTypes[23] = saturation;
        potionTypes[24] = glowing;
        potionTypes[25] = levitation;
        potionTypes[26] = luckBoost;
        potionTypes[27] = unluck;
    }
}
