package org.siberianhusky.huskycore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.siberianhusky.huskycore.data.Data;
import org.siberianhusky.huskycore.register.All;

public final class HuskyCore extends JavaPlugin {
    public static HuskyCore husky;
    @Override
    public void onEnable() {
        //检测是否加载PlaceholderAPI
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Data.isLoadPapi = true;
        }
        //注册所有
        All all = new All();
        all.registerAll(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
