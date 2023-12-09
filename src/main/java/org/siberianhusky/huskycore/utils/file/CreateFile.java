package org.siberianhusky.huskycore.utils.file;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CreateFile {
    /**
     * 创建Yaml文件
     * @param path 文件路径
     * @param plugin 插件
     * @return 文件配置
     */
    public static FileConfiguration createYamlFile(String path,JavaPlugin plugin){
        plugin.saveResource(path,false);
        File file = new File(plugin.getDataFolder(),path);
        return YamlConfiguration.loadConfiguration(file);
    }
    /**
     * 创建文件
     * @param path 文件路径
     * @return 0:创建成功 1:文件已存在 -1:创建失败
     */
    public static int createFile(String path){
        File file = new File(path);
        if(file.exists()){
            return 1;
        }else{
            try{
                file.createNewFile();
                return 0;
            }catch (Exception e){
                return -1;
            }
        }
    }
}
