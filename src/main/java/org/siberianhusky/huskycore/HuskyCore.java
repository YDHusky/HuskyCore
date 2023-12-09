package org.siberianhusky.huskycore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.siberianhusky.huskycore.data.Data;

public final class HuskyCore extends JavaPlugin {

    @Override
    public void onEnable() {
        //检测是否加载PlaceholderAPI
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Data.isLoadPapi = true;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
