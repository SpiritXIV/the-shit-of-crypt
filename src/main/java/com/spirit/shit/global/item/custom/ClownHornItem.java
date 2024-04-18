package com.spirit.shit.global.item.custom;

import com.spirit.shit.global.sound.ShitSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ClownHornItem extends Item {

    public ClownHornItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        world.playSoundFromEntity(null, player, ShitSounds.CLOWNHORN, SoundCategory.PLAYERS, 1.0f, 1.0f);
        player.emitGameEvent(GameEvent.INSTRUMENT_PLAY);
        player.getItemCooldownManager().set(this, 20);

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSoundFromEntity(null, target, ShitSounds.CLOWNHORN, SoundCategory.PLAYERS, 1.0f, 1.0f);
        target.emitGameEvent(GameEvent.INSTRUMENT_PLAY);

        return super.postHit(stack, target, attacker);
    }
}
