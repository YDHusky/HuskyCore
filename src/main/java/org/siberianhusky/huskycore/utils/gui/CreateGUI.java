package org.siberianhusky.huskycore.utils.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.siberianhusky.huskycore.api.GUI;

import java.util.Map;

public class CreateGUI implements GUI {
    private Inventory gui;
    private String title;
    private int size;
    private Player player;
    private Map<Integer, ItemStack> items;

    public CreateGUI(String title, int size, Player player) {
        this.title = title;
        this.size = size;
        this.player = player;
    }

    public CreateGUI(String title, int size, Player player, Map<Integer, ItemStack> items) {
        this.title = title;
        this.size = size;
        this.player = player;
        this.items = items;

    }

    @Override
    public void openInventory() {
        this.setItems();
        this.player.openInventory(gui);
    }

    @Override
    public void ref() {
        this.gui.clear();
        this.setItems();
        this.player.openInventory(gui);
    }

    @Override
    public void setItems() {
        for (Map.Entry<Integer, ItemStack> entry : items.entrySet()) {
            gui.setItem(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    public Inventory getGui() {
        return gui;
    }

    public void setGui(Inventory gui) {
        this.gui = gui;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<Integer, ItemStack> getItems() {
        return items;
    }

    public void setItems(Map<Integer, ItemStack> items) {
        this.items = items;
    }
}
