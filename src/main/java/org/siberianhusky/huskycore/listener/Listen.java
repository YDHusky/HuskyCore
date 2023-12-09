package org.siberianhusky.huskycore.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.siberianhusky.huskycore.api.GUI;

public class Listen implements Listener {
    @EventHandler
    public void onGui(InventoryClickEvent event){
        if (event.getInventory().getHolder() instanceof GUI){
            event.setCancelled(true);
        }
    }
}
