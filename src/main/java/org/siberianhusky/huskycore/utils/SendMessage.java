package org.siberianhusky.huskycore.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMessage {
    /**
     * 发送消息给玩家
     * @param message 消息
     * @param player 玩家
     */
    public static void send(String message, Player player) {
        player.sendMessage(Replace.replaceAll(message, player));
    }
    /**
     * 发送消息给指令发送者
     * @param message 消息
     * @param sender 指令发送者
     */
    public static void send(String message, CommandSender sender) {
        sender.sendMessage(Replace.replaceColor(message));
    }
}
