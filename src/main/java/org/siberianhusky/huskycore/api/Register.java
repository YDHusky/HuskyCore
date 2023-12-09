package org.siberianhusky.huskycore.api;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public interface Register {
    void registerCommand();
    void registerListener(JavaPlugin plugin);

    default void registerAll(JavaPlugin plugin){
        registerCommand();
        registerListener(plugin);
    }
}
