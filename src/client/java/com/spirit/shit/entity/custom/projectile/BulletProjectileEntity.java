package com.spirit.shit.entity.custom.projectile;

import com.spirit.shit.ShitMod;
import com.spirit.shit.item.ShitItems;
import com.spirit.shit.sound.ShitSounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BulletProjectileEntity extends ThrownItemEntity {
    public BulletProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ShitItems.BULLET_ENTITY;
    }

    public BulletProjectileEntity(World world, LivingEntity owner) {
        super(ShitMod.BulletProjectileEntityType, owner, world);
    }

    public BulletProjectileEntity(World world, double x, double y, double z) {
        super(ShitMod.BulletProjectileEntityType, x, y, z, world);
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return (ParticleEffect)(itemStack.isEmpty() ? ParticleTypes.SMALL_FLAME : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), getRotationVecClient().getX() + 10.0D, getRotationVecClient().getY() + 0.0D, getRotationVecClient().getZ() + 10.0D);
            }
        }

    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof PlayerEntity ? 3 : 0;

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.damage(new DamageSource(RegistryEntry.of(new DamageType("shot", 1))), 2);
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.playSound(ShitSounds.BULLET_IMPACT, 10F, 1F);
            this.kill();
        }

    }
}
