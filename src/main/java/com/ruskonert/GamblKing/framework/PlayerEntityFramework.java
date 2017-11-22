package com.ruskonert.GamblKing.framework;

import com.ruskonert.GamblKing.entity.Player;
import com.ruskonert.GamblKing.util.SecurityUtil;

public class PlayerEntityFramework implements Player
{
    public PlayerEntityFramework() {}
    private String id;
    @Override public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    private String nickname;
    @Override public String getNickname() { return this.nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    private String password;
    public void setPassword(String password) { this.password = SecurityUtil.Companion.sha256(password); }
    @Override public String getPassword() { return this.password; }

    private int victory;
    @Override public int getVictory() {
        return this.victory;
    }
    public void setVictory(int victory) { this.victory = victory; }

    private int defeat;
    public void setDefeat(int defeat) { this.defeat = defeat; }
    @Override public int getDefeated() {
        return this.defeat;
    }

    private String lastConnected;
    public void setLastConnected(String lastConnected) { this.lastConnected = lastConnected; }
    @Override public String getLastConnected() { return lastConnected; }

    @Override
    public boolean isEnteredRoom()
    {
        try
        {
            throw new RuntimeException("Not implemented");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String lastBattlePlayer;
    public void setLastBattlePlayer(String lastBattlePlayer) { this.lastBattlePlayer = lastBattlePlayer; }

    @Override
    public String getLastBattlePlayer() {
        return this.lastBattlePlayer;
    }

    private String hostAddress;
    public void setHostAddress(String hostAddress) { this.hostAddress = hostAddress; }
    @Override
    public String getHostAddress() {
        return this.hostAddress;
    }

    @Override
    public void sendMessage(String message)
    {
        try
        {
            throw new RuntimeException("Not implemented");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
