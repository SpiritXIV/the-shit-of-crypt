package com.spirit.koil.api.bukkit.event.block;

import com.google.common.base.Preconditions;
import com.spirit.koil.api.bukkit.block.Block;
import com.spirit.koil.api.bukkit.block.SculkCatalyst;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an event triggered when a new cursor is created by a {@link SculkCatalyst}.
 * <p>
 * <strong>Cursor Definition:</strong>
 * A cursor in this context is a dynamic marker or pointer generated by the
 * SculkCatalyst. It occupies a block and spreads sculk as it moves. It is
 * similar to entity, but it is not an entity. Cursors are ticked by the
 * tile entity.
 * <p>
 * <strong>Triggers for Cursor Creation:</strong>
 * <ul>
 *   <li>An entity, when killed and drops experience, within an 8-block radius of a {@link SculkCatalyst}.</li>
 *   <li>An explicit call from a plugin using {@link SculkCatalyst#bloom(Block, int)}.</li>
 * </ul>
 *
 * The result of {@link #getBlock()} is the location that the cursor is spawning at.
 */
public class SculkBloomEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;

    private int charge;

    public SculkBloomEvent(@NotNull Block theBlock, int charge) {
        super(theBlock);
        this.charge = charge;
    }

    /**
     * Returns the charge of the cursor, &lt; 1000 by default.
     *
     * @return the charge of the cursor
     */
    public int getCharge() {
        return charge;
    }

    /**
     * Sets the charge of the cursor.
     * <p>
     * Increasing the charge of a cursor makes the cursor last longer, giving
     * it more time to spread sculk blocks across a larger range.
     * <p>
     * Typically, charges should be set to the exp reward of a mob
     * ({@link EntityDeathEvent#getDroppedExp()}), which is usually
     * 3-5 for animals, and 5-10 for the average mob (up to 50 for
     * wither skeletons). Roughly speaking, for each charge, 1 more
     * sculk block will be placed.
     *
     * @param charge the charge of the cursor.
     */
    public void setCharge(int charge) {
        Preconditions.checkArgument(charge >= 0 && charge <= 1000, charge + " is not in range [0, 1000]");
        this.charge = charge;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
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
