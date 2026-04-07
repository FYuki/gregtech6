package net.minecraft.world.entity.boss.enderdragon;
// PHASE3: stub - EnderDragonPart removed/reworked in 1.21
import net.minecraft.world.entity.PartEntity;
public class EnderDragonPart extends PartEntity<EnderDragon> {
    public final EnderDragon parentMob;
    public final String name;
    public EnderDragonPart(EnderDragon dragon, String name, float w, float h) {
        super(dragon);
        this.parentMob = dragon;
        this.name = name;
    }
}
