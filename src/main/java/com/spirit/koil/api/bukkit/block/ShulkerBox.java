package com.spirit.koil.api.bukkit.block;

import com.spirit.koil.api.bukkit.DyeColor;
import com.spirit.koil.api.bukkit.loot.Lootable;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a captured state of a ShulkerBox.
 */
public interface ShulkerBox extends Container, Lootable, Lidded {

    /**
     * Get the {@link DyeColor} corresponding to this ShulkerBox
     *
     * @return the {@link DyeColor} of this ShulkerBox, or null if default
     */
    @Nullable
    public DyeColor getColor();
}
