package com.spirit.koil.api.bukkit.inventory.meta;

import java.util.List;
import com.spirit.koil.api.bukkit.MinecraftExperimental;
import com.spirit.koil.api.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@MinecraftExperimental
@ApiStatus.Experimental
public interface BundleMeta extends ItemMeta {

    /**
     * Returns whether the item has any items.
     *
     * @return whether items are present
     */
    boolean hasItems();

    /**
     * Returns an immutable list of the items stored in this item.
     *
     * @return items
     */
    @NotNull
    List<ItemStack> getItems();

    /**
     * Sets the items stored in this item.
     * <br>
     * Removes all items when given null.
     *
     * @param items the items to set
     */
    void setItems(@Nullable List<ItemStack> items);

    /**
     * Adds an item to this item.
     *
     * @param item item to add
     */
    void addItem(@NotNull ItemStack item);
}
