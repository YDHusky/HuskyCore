package org.siberianhusky.huskycore.team;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class TeamInfo implements Team {
    private String name;
    private Component displayName;
    private Component prefix;
    private Component suffix;
    private ChatColor color;
    private TextColor textColor;
    private boolean allowFriendlyFire;
    private boolean canSeeFriendlyInvisibles;
    private NameTagVisibility nameTagVisibility;
    private Set<OfflinePlayer> players;
    private Set<String> entries;
    private int size;
    private Scoreboard scoreboard;
    private OptionStatus optionStatus;
    private Location spawn;
    private int score = 0;

    public TeamInfo(String name, Component displayName, Scoreboard scoreboard) {
        this.name = name;
        this.displayName = displayName;
        this.scoreboard = scoreboard;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDisplayName(Component displayName) {
        this.displayName = displayName;
    }

    public void setPrefix(Component prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(Component suffix) {
        this.suffix = suffix;
    }

    public TextColor getTextColor() {
        return textColor;
    }

    public void setTextColor(TextColor textColor) {
        this.textColor = textColor;
    }

    public boolean isAllowFriendlyFire() {
        return allowFriendlyFire;
    }

    public boolean isCanSeeFriendlyInvisibles() {
        return canSeeFriendlyInvisibles;
    }

    public void setPlayers(Set<OfflinePlayer> players) {
        this.players = players;
    }

    public void setEntries(Set<String> entries) {
        this.entries = entries;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public OptionStatus getOptionStatus() {
        return optionStatus;
    }

    public void setOptionStatus(OptionStatus optionStatus) {
        this.optionStatus = optionStatus;
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public @NotNull String getName() throws IllegalStateException {
        return name;
    }

    @Override
    public @NotNull Component displayName() throws IllegalStateException {
        return displayName;
    }

    @Override
    public void displayName(@Nullable Component component) throws IllegalStateException, IllegalArgumentException {
        this.displayName = component;
    }

    @Override
    public @NotNull Component prefix() throws IllegalStateException {
        return prefix;
    }

    @Override
    public void prefix(@Nullable Component component) throws IllegalStateException, IllegalArgumentException {
        this.prefix = component;
    }

    @Override
    public @NotNull Component suffix() throws IllegalStateException {
        return suffix;
    }

    @Override
    public void suffix(@Nullable Component component) throws IllegalStateException, IllegalArgumentException {
        this.suffix = component;
    }

    @Override
    public boolean hasColor() {
        return this.color != null;
    }

    @Override
    public @NotNull TextColor color() throws IllegalStateException {
        return textColor;
    }

    @Override
    public void color(@Nullable NamedTextColor namedTextColor) {
        this.textColor = namedTextColor;
    }

    @Override
    public @NotNull String getDisplayName() throws IllegalStateException {
        return displayName.toString();
    }

    @Override
    public void setDisplayName(@NotNull String s) throws IllegalStateException, IllegalArgumentException {
        this.displayName = Component.text(s);
    }

    @Override
    public @NotNull String getPrefix() throws IllegalStateException {
        return prefix.toString();
    }

    @Override
    public void setPrefix(@NotNull String s) throws IllegalStateException, IllegalArgumentException {
        this.prefix = Component.text(s);
    }

    @Override
    public @NotNull String getSuffix() throws IllegalStateException {
        return suffix.toString();
    }

    @Override
    public void setSuffix(@NotNull String s) throws IllegalStateException, IllegalArgumentException {
        this.suffix = Component.text(s);
    }

    @Override
    public @NotNull ChatColor getColor() throws IllegalStateException {
        return color;
    }

    @Override
    public void setColor(@NotNull ChatColor chatColor) {
        this.color = chatColor;
    }

    @Override
    public boolean allowFriendlyFire() throws IllegalStateException {
        return allowFriendlyFire;
    }

    @Override
    public void setAllowFriendlyFire(boolean b) throws IllegalStateException {
        this.allowFriendlyFire = b;
    }

    @Override
    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        return canSeeFriendlyInvisibles;
    }

    @Override
    public void setCanSeeFriendlyInvisibles(boolean b) throws IllegalStateException {
        this.canSeeFriendlyInvisibles = b;
    }

    @Override
    public @NotNull NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
        return nameTagVisibility;
    }

    @Override
    public void setNameTagVisibility(@NotNull NameTagVisibility nameTagVisibility) throws IllegalArgumentException {
        this.nameTagVisibility = nameTagVisibility;
    }

    @Override
    public @NotNull Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        return players;
    }

    @Override
    public @NotNull Set<String> getEntries() throws IllegalStateException {
        return entries;
    }

    @Override
    public int getSize() throws IllegalStateException {
        return size;
    }

    @Override
    public @Nullable Scoreboard getScoreboard() {
        return scoreboard;
    }

    @Override
    public void addPlayer(@NotNull OfflinePlayer offlinePlayer) throws IllegalStateException, IllegalArgumentException {
        players.add(offlinePlayer);
        entries.add(offlinePlayer.getName());
    }

    @Override
    public void addEntry(@NotNull String s) throws IllegalStateException, IllegalArgumentException {
        entries.add(s);
        players.add(Bukkit.getOfflinePlayer(s));
    }

    @Override
    public void addEntities(@NotNull Collection<Entity> collection) throws IllegalStateException, IllegalArgumentException {
        for (Entity entity : collection) {
            players.add((OfflinePlayer) entity);
            entries.add(entity.getName());
        }
    }

    @Override
    public void addEntries(@NotNull Collection<String> collection) throws IllegalStateException, IllegalArgumentException {
        for (String s : collection) {
            entries.add(s);
            players.add(Bukkit.getOfflinePlayer(s));
        }
    }

    @Override
    public boolean removePlayer(@NotNull OfflinePlayer offlinePlayer) throws IllegalStateException, IllegalArgumentException {
        players.remove(offlinePlayer);
        entries.remove(offlinePlayer.getName());
        return false;
    }

    @Override
    public boolean removeEntry(@NotNull String s) throws IllegalStateException, IllegalArgumentException {
        entries.remove(s);
        players.remove(Bukkit.getOfflinePlayer(s));
        return false;
    }

    @Override
    public boolean removeEntities(@NotNull Collection<Entity> collection) throws IllegalStateException, IllegalArgumentException {
        for (Entity entity : collection) {
            players.remove((OfflinePlayer) entity);
            entries.remove(entity.getName());
        }
        return false;
    }

    @Override
    public boolean removeEntries(@NotNull Collection<String> collection) throws IllegalStateException, IllegalArgumentException {
        for (String s : collection) {
            entries.remove(s);
            players.remove(Bukkit.getOfflinePlayer(s));
        }
        return false;
    }

    @Override
    public void unregister() throws IllegalStateException {
        Objects.requireNonNull(scoreboard.getTeam(name)).unregister();
    }

    @Override
    public boolean hasPlayer(@NotNull OfflinePlayer offlinePlayer) throws IllegalArgumentException, IllegalStateException {
        return !players.isEmpty();
    }

    @Override
    public boolean hasEntry(@NotNull String s) throws IllegalArgumentException, IllegalStateException {
        return !entries.isEmpty();
    }

    @Override
    public @NotNull OptionStatus getOption(@NotNull Option option) throws IllegalStateException {
        return optionStatus;
    }

    @Override
    public void setOption(@NotNull Option option, @NotNull OptionStatus optionStatus) throws IllegalStateException {
        this.optionStatus = optionStatus;
    }

    @Override
    public void addEntity(@NotNull Entity entity) throws IllegalStateException, IllegalArgumentException {
        this.entries.add(entity.getName());
        this.players.add((OfflinePlayer) entity);
    }

    @Override
    public boolean removeEntity(@NotNull Entity entity) throws IllegalStateException, IllegalArgumentException {
        this.entries.remove(entity.getName());
        this.players.remove((OfflinePlayer) entity);
        return false;
    }

    @Override
    public boolean hasEntity(@NotNull Entity entity) throws IllegalStateException, IllegalArgumentException {
        return !entries.isEmpty();
    }
}
