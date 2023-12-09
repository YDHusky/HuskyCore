package org.siberianhusky.huskycore.utils.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class LoadFile {
    /**
     * 重载Yaml文件
     * @param path 文件路径
     * @param plugin 插件
     * @return 文件配置
     */
    public static FileConfiguration reloadFile(String path,JavaPlugin plugin){
        File file = new File(plugin.getDataFolder(),path);
        return YamlConfiguration.loadConfiguration(file);
    }
}
