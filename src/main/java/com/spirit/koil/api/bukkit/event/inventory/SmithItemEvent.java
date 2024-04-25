package com.spirit.koil.api.bukkit.event.inventory;

import com.spirit.koil.api.bukkit.inventory.InventoryView;
import com.spirit.koil.api.bukkit.inventory.SmithingInventory;
import org.jetbrains.annotations.NotNull;

/**
 * Called when the recipe of an Item is completed inside a smithing table.
 */
public class SmithItemEvent extends InventoryClickEvent {

    public SmithItemEvent(@NotNull InventoryView view, @NotNull InventoryType.SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action) {
        super(view, type, slot, click, action);
    }

    public SmithItemEvent(@NotNull InventoryView view, @NotNull InventoryType.SlotType type, int slot, @NotNull ClickType click, @NotNull InventoryAction action, int key) {
        super(view, type, slot, click, action, key);
    }

    @NotNull
    @Override
    public SmithingInventory getInventory() {
        return (SmithingInventory) super.getInventory();
    }
}
