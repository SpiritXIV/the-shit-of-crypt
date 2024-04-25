package com.spirit.koil.api.bukkit.event.entity;

import com.spirit.koil.api.bukkit.entity.Sheep;
import com.spirit.koil.api.bukkit.event.Cancellable;
import com.spirit.koil.api.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a sheep regrows its wool
 */
public class SheepRegrowWoolEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;

    public SheepRegrowWoolEvent(@NotNull final Sheep sheep) {
        super(sheep);
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

    @NotNull
    @Override
    public Sheep getEntity() {
        return (Sheep) entity;
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
