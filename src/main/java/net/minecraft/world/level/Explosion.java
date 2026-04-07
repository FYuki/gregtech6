package net.minecraft.world.level;
// PHASE3: stub - Explosion API changed significantly in 1.21; full rewrite needed
// Fields/methods match MC 1.7.10 / GT6 usage patterns
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Explosion {
    public float explosionSize;
    public double explosionX, explosionY, explosionZ;
    public boolean isFlaming;
    public boolean isSmoking = true;
    public Entity exploder;
    public List<BlockPos> affectedBlockPositions = new ArrayList<>();

    public Explosion(Level world, Entity entity, double x, double y, double z, float size) {
        this.explosionX = x;
        this.explosionY = y;
        this.explosionZ = z;
        this.explosionSize = size;
        this.exploder = entity;
    }

    public void doExplosionA() {}
    public void doExplosionB(boolean spawnParticles) {}
    public java.util.Map<Entity, net.minecraft.world.phys.Vec3> func_77277_b() { return new java.util.HashMap<>(); }
}
