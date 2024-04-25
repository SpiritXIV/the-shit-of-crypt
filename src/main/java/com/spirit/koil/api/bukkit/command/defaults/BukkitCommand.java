package com.spirit.koil.api.bukkit.command.defaults;

import java.util.List;
import com.spirit.koil.api.bukkit.command.Command;
import org.jetbrains.annotations.NotNull;

public abstract class BukkitCommand extends Command {
    protected BukkitCommand(@NotNull String name) {
        super(name);
    }

    protected BukkitCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }
}
