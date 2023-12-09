package org.siberianhusky.huskycore.api;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public interface GUI extends InventoryHolder {
    //打开gui
    void openInventory();
    //刷新
    void ref();
    //设置gui中物品
    void setItems();
}
