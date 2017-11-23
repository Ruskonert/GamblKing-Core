package com.ruskonert.GamblKing.framework;

import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.entity.Player;

public class RoomFramework implements Room
{
    private String name;
    @Override public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private Player leader;
    @Override public Player getLeader() { return leader; }
    public void setLeader(Player player) { this.leader = player; }

    private Player waitPlayer;
    @Override public Player getWaitPlayer() { return this.waitPlayer; }
    public void setWaitPlayer(Player player) { this.waitPlayer = player; }

    private String createDate = null;
    @Override public String getCreateDate() { return this.createDate; }
    public void setCreateDate(String date) { createDate = date; }

    @Override public synchronized void close()
    {

    }

    public void update()
    {

    }


    private RoomFramework()
    {

    }

    public static Room generate(Player player, String name)
    {
        RoomFramework framework = new RoomFramework();
        framework.name = name;
        framework.leader = player;
        return framework;
    }
}
