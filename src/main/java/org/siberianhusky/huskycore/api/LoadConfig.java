package org.siberianhusky.huskycore.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public interface LoadConfig {
    /**
     * 加载所有配置
     * @param plugin 插件
     */
    void loadAllConfig(JavaPlugin plugin);
    /**
     * 重载所有配置
     * @param plugin 插件
     */
    void reloadAllConfig(JavaPlugin plugin);
    /**
     * 加载默认配置
     * @param plugin 插件
     * @return 默认配置
     */
      default FileConfiguration loadDefaultConfig(JavaPlugin plugin){
        plugin.saveDefaultConfig();
        return plugin.getConfig();
    }
    /**
     * 重载默认配置
     * @param plugin 插件
     * @return 默认配置
     */
    default FileConfiguration reloadDefaultConfig(String path,JavaPlugin plugin){
       plugin.reloadConfig();
         return plugin.getConfig();
    }
}

