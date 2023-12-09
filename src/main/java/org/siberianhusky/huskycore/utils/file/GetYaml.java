package org.siberianhusky.huskycore.utils.file;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class GetYaml {
    /**
     * 获取Yaml文件中的String
     * @param yaml Yaml文件
     * @param key 键
     * @return 值
     */
    public static String get(FileConfiguration yaml, String key) {
        return yaml.getString(key);
    }
    /**
     * 获取Yaml文件中的Int
     * @param yaml Yaml文件
     * @param key 键
     * @return 值
     */
    public static List<String> getList(FileConfiguration yaml, String key) {
        return yaml.getStringList(key);
    }
}
