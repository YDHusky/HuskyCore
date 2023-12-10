package org.siberianhusky.huskycore.register;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.siberianhusky.huskycore.api.Register;
import org.siberianhusky.huskycore.listener.Listen;

public class All implements Register {
    @Override
    public void registerCommand() {

    }

    @Override
    public void registerListener(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new Listen(),plugin);
    }

    @Override
    public void registerAll(JavaPlugin plugin) {
        registerCommand();
        registerListener(plugin);
    }
}
