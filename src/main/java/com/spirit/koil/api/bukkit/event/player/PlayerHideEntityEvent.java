package com.spirit.koil.api.bukkit.event.player;

import com.spirit.koil.api.bukkit.entity.Entity;
import com.spirit.koil.api.bukkit.entity.Player;
import com.spirit.koil.api.bukkit.event.HandlerList;
import com.spirit.koil.api.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a visible entity is hidden from a player.
 * <br>
 * This event is only called when the entity's visibility status is actually
 * changed.
 * <br>
 * This event is called regardless of if the entity was within tracking range.
 *
 * @see Player#hideEntity(Plugin, Entity)
 */
public class PlayerHideEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;

    public PlayerHideEntityEvent(@NotNull Player who, @NotNull Entity entity) {
        super(who);
        this.entity = entity;
    }

    /**
     * Gets the entity which has been hidden from the player.
     *
     * @return the hidden entity
     */
    @NotNull
    public Entity getEntity() {
        return entity;
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
