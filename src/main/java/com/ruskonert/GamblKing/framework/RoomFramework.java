package com.ruskonert.GamblKing.framework;

import com.ruskonert.GamblKing.entity.Room;

public class RoomFramework implements Room
{
    private String name;
    @Override public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    private String leaderName;
    @Override public String getLeaderName() { return leaderName; }
    public void setLeader(String name) { this.leaderName = name; }

    private String waitPlayerName;
    @Override public String getWaitPlayerName() { return this.waitPlayerName; }
    public void setWaitPlayer(String name) { this.waitPlayerName = name; }

    private String createDate = null;
    @Override public String getCreateDate() { return this.createDate; }
    public void setCreateDate(String date) { createDate = date; }

    @Override public synchronized void close()
    {
    }


    private RoomFramework()
    {

    }

    public static Room generate(String playername, String name)
    {
        RoomFramework framework = new RoomFramework();
        framework.name = name;
        framework.leaderName = playername;
        return framework;
    }
}
