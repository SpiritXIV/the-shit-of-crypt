package com.spirit.koil.api.bukkit.event.entity;

import com.spirit.koil.api.bukkit.Location;
import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.entity.Entity;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Called when an entity explodes
 */
public class EntityExplodeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private final Location location;
    private final List<Block> blocks;
    private float yield;

    public EntityExplodeEvent(@NotNull final Entity what, @NotNull final Location location, @NotNull final List<Block> blocks, final float yield) {
        super(what);
        this.location = location;
        this.blocks = blocks;
        this.yield = yield;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Returns the list of blocks that would have been removed or were removed
     * from the explosion event.
     *
     * @return All blown-up blocks
     */
    @NotNull
    public List<Block> blockList() {
        return blocks;
    }

    /**
     * Returns the location where the explosion happened.
     * <p>
     * It is not possible to get this value from the Entity as the Entity no
     * longer exists in the world.
     *
     * @return The location of the explosion
     */
    @NotNull
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the percentage of blocks to drop from this explosion
     *
     * @return The yield.
     */
    public float getYield() {
        return yield;
    }

    /**
     * Sets the percentage of blocks to drop from this explosion
     *
     * @param yield The new yield percentage
     */
    public void setYield(float yield) {
        this.yield = yield;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
