package org.siberianhusky.huskycore.team;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.*;

public class HuskyTeam {
    //队伍统治者
    private String ruler;
    //队伍计分板
    private Scoreboard scoreboard;
    //队伍
    private Team team;
    //队伍id
    private String id;
    //队伍分数
    private int score=0;
    //队伍出生点
    private Location spawn;
    //玩家状态，小游戏使用(0存活，1死亡)
    private Map<String,Integer> player=new HashMap<>();
    //是否为小游戏模式
    private boolean isGameMode = false;
    //队伍申请列表
    private Set<OfflinePlayer> applicant = new HashSet<>();
    //队伍黑名单
    private Set<OfflinePlayer> blackList = new HashSet<>();
    //队伍管理层
    private Set<OfflinePlayer> opList = new HashSet<>();

    /**
     * 创建队伍
     * @param scoreboard 计分板
     * @param team 队伍
     * @param id 队伍id
     */
    public HuskyTeam(Scoreboard scoreboard, Team team, String id) {
        this.scoreboard = scoreboard;
        this.team = team;
        this.id = id;
    }

    public void addScore(int score) {
        this.score += score;
    }
    private void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void clearScore() {
        setScore(0);
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public Team getTeam() {
        return team;
    }

    public String getId() {
        return id;
    }

    public int cleanNotOnlinePlayer() {
        int count = 0;
        for (String entry : team.getEntries()) {
            if (Bukkit.getPlayer(entry) == null) {
                team.removeEntry(entry);
                count++;
            }
        }
        return count;
    }

    public void unregister() {
        Objects.requireNonNull(scoreboard.getTeam(team.getName())).unregister();
    }

    public Location getSpawn() {
        return spawn;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public boolean isGameMode() {
        return isGameMode;
    }

    public void setGameMode(boolean gameMode) {
        isGameMode = gameMode;
    }

    public void gameStart() {
        if (isGameMode) {
            for (String entry : team.getEntries()) {
                if (Bukkit.getPlayer(entry) != null) {
                    player.put(entry,0);
                }
            }
        }
    }

    private void playerDeath(String player) {
        if (isGameMode) {
            this.player.put(player,1);
        }
    }

    public Map<String, Integer> getPlayer() {
        return player;
    }

    public String getRuler() {
        return ruler;
    }

    public void setRuler(String ruler) {
        this.ruler = ruler;
    }

    public Set<OfflinePlayer> getApplicant() {
        return applicant;
    }

    /**
     * @return 0:成功 1:黑名单 2:已在队伍中
     */
    public int addApplicant(OfflinePlayer player) {
        if (blackList.contains(player)) {
            return 1;
        } else if (team.getEntries().contains(player.getName())) {
            return 2;
        }
        else {
            applicant.add(player);
            return 0;
        }
    }

    public void agreeApplicant(OfflinePlayer player) {
        applicant.remove(player);
        team.addEntry(player.getName());
    }

    public void refuseApplicant(OfflinePlayer player) {
        applicant.remove(player);
    }

    public void addBlackList(OfflinePlayer player) {
        blackList.add(player);
    }

    public void removeBlackList(OfflinePlayer player) {
        blackList.remove(player);
    }

    public Set<OfflinePlayer> getBlackList() {
        return blackList;
    }

    public Set<OfflinePlayer> getOpList() {
        return opList;
    }

    public void addOpList(OfflinePlayer player) {
        opList.add(player);
    }

    public void removeOpList(OfflinePlayer player) {
        opList.remove(player);
    }
}
