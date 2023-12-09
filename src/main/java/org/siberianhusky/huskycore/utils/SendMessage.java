package org.siberianhusky.huskycore.utils;

import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.siberianhusky.huskycore.utils.file.GetYaml;

import java.util.List;

public class SendMessage {
    /**
     * 发送消息给玩家
     * @param message 消息
     * @param player 玩家
     */
    public static void send(String message, Player player) {
        player.sendMessage(StringUtils.replaceAll(message, player));
    }
    /**
     * 发送消息给指令发送者
     * @param message 消息
     * @param sender 指令发送者
     */
    public static void send(String message, CommandSender sender) {
        sender.sendMessage(StringUtils.replaceColor(message));
    }
    /**
     * 发送消息给玩家列表
     * @param messages 消息列表
     * @param player 玩家列表
     */
    public static void sendList(List<String> messages, Player player) {
        for (String msg : messages) {
            send(msg, player);
        }
    }
    /**
     * 发送消息给指令发送者列表
     * @param messages 消息列表
     * @param sender 指令发送者列表
     */
    public static void sendList(List<String> messages, CommandSender sender) {
        for (String msg : messages) {
            send(msg, sender);
        }
    }
    /**
     * 发送Yaml文件中的消息给玩家
     * @param yaml Yaml文件
     * @param key 键
     * @param player 玩家
     */
    public static void sendYaml(FileConfiguration yaml,String key,Player player){
        send(GetYaml.get(yaml,key),player);
    }
    /**
     * 发送Yaml文件中的消息给指令发送者
     * @param yaml Yaml文件
     * @param key 键
     * @param sender 指令发送者
     */
    public static void sendYaml(FileConfiguration yaml,String key,CommandSender sender){
        send(GetYaml.get(yaml,key),sender);
    }
    /**
     * 发送Yaml文件中的消息列表给玩家
     * @param yaml Yaml文件
     * @param key 键
     * @param player 玩家
     */
    public static void sendYamlList(FileConfiguration yaml,String key,Player player){
        sendList(GetYaml.getList(yaml,key),player);
    }
    /**
     * 发送Yaml文件中的消息列表给指令发送者
     * @param yaml Yaml文件
     * @param key 键
     * @param sender 指令发送者
     */
    public static void sendYamlList(FileConfiguration yaml,String key,CommandSender sender){
        sendList(GetYaml.getList(yaml,key),sender);
    }
    /**
     * 发送消息给所有玩家
     * @param message 消息
     */
    public static void send(String message){
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(message,player);
        }
    }

    /**
     * 发送Title给玩家
     * @param title Title
     * @param player 玩家
     */
    public static void send(Title title,Player player){
        player.showTitle(title);
    }
    /**
     * 发送Title给所有玩家
     * @param title Title
     */
    public static void send(Title title){
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(title,player);
        }
    }

}
