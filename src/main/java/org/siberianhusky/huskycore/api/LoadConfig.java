package org.siberianhusky.huskycore.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.siberianhusky.huskycore.utils.file.CreateFile;

import java.io.File;


public interface LoadConfig {
    /**
     * 加载配置文件
     * @param plugin 插件
     */
    default void loadFileConfig(JavaPlugin plugin){}
    /**
     * 重载配置文件
     * @param plugin 插件
     */
    default void reloadFileConfig(JavaPlugin plugin){}
    /**
     * 加载默认配置
     * @param plugin 插件
     * @return 默认配置
     */
    default void loadDefaultConfig(JavaPlugin plugin){
        plugin.saveDefaultConfig();
        plugin.getConfig();
    }
    /**
     * 重载默认配置
     * @param plugin 插件
     */
    default void reloadDefaultConfig(JavaPlugin plugin){
       plugin.reloadConfig();
       plugin.getConfig();
    }
    /**
     * 加载所有配置
     * @param plugin 插件
     */
    default void loadAllConfig(JavaPlugin plugin){
        loadFileConfig(plugin);
        loadDefaultConfig(plugin);
    }
    /**
     * 重载所有配置
     * @param plugin 插件
     */
    default void reloadAllConfig(String path,JavaPlugin plugin){
        reloadFileConfig(plugin);
        reloadDefaultConfig(plugin);
    }
}

