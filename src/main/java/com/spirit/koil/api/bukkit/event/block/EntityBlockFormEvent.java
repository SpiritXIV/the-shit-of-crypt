package com.spirit.koil.api.bukkit.event.block;

import com.spirit.koil.api.bukkit.entity.Snowman;
import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.block.BlockState;
import com.spirit.koil.api.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a block is formed by entities.
 * <p>
 * Examples:
 * <ul>
 * <li>Snow formed by a {@link Snowman}.
 * <li>Frosted Ice formed by the Frost Walker enchantment.
 * </ul>
 */
public class EntityBlockFormEvent extends BlockFormEvent {
    private final Entity entity;

    public EntityBlockFormEvent(@NotNull final Entity entity, @NotNull final Block block, @NotNull final BlockState blockstate) {
        super(block, blockstate);

        this.entity = entity;
    }

    /**
     * Get the entity that formed the block.
     *
     * @return Entity involved in event
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }
}
