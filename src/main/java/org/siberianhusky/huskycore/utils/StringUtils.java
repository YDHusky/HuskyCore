package org.siberianhusky.huskycore.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    /**
     * 替换文本中的颜色&
     * @param text 要替换的文本
     * @return 被替换过后的文本
     */
    public static String replaceColor(String text) {
        return text.replace("&", "§");
    }

    /**
     * 替换文本中的papi变量
     * @param text 要替换的文本
     * @param player 解析玩家
     * @return 被替换过后的文本
     */
    public static String replacePapi(String text, Player player){
        return PlaceholderAPI.setPlaceholders(player, text);
    }

    /**
     * 替换文本中的颜色&和papi变量
     * @param text 要替换的文本
     * @param player 解析玩家
     * @return 被替换过后的文本
     */
    public static String replaceAll(String text, Player player){
        return replacePapi(replaceColor(text), player);
    }

    /**
     * 替换某一个文本和颜色
     * @param text 文本
     * @param attribute 属性
     * @param value 值
     * @return 被替换过后的文本
     */
    public static String replaceAttribute(String text, String attribute, String value){
        return replaceColor(text.replace(attribute, value));
    }

    /**
     * 替换某一个文本和颜色和papi变量
     * @param text 文本
     * @param attribute 属性
     * @param value 值
     * @param player 解析玩家
     * @return 被替换过后的文本
     */
    public static String replaceAttribute(String text, String attribute, String value,Player player){
        return replaceAll(text.replace(attribute, value), player);
    }

    /**
     * 替换List中的颜色&
     * @param list 要替换的List
     * @return 被替换过后的List
     */
    public static List<String> replaceColor(List<String> list){
        List<String> newList = new ArrayList<>();
        for (String text: list) {
            newList.add(replaceColor(text));
        }
        return newList;
    }

    /**
     * 替换List中的papi变量
     * @param list 要替换的List
     * @param player 解析玩家
     * @return 被替换过后的List
     */
    public static List<String> replacePapi(List<String> list, Player player){
        List<String> newList = new ArrayList<>();
        for (String text: list) {
            newList.add(replaceAll(text, player));
        }
        return newList;
    }


    /**
     * 替换某一个文本和颜色和papi变量
     * @param list 文本
     * @param attribute 属性
     * @param value 值
     * @param player 解析玩家
     * @return 被替换过后的文本
     */
    public static List<String> replacePapi(List<String> list,String attribute,String value,Player player){
        List<String> newList = new ArrayList<>();
        for (String text: list) {
            newList.add(replaceAttribute(text, attribute,value,player));
        }
        return newList;
    }

    /**
     * 替换某一个文本和颜色和papi变量
     * @param list 文本
     * @param attribute 属性
     * @param value 值
     * @return 被替换过后的文本
     */
    public static List<String> replacePapi(List<String> list,String attribute,String value){
        List<String> newList = new ArrayList<>();
        for (String text: list) {
            newList.add(replaceAttribute(text, attribute,value));
        }
        return newList;
    }
}
