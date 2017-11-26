package com.ruskonert.GamblKing.entity;

public interface Room
{
    String getName();

    String getLeaderName();

    String getWaitPlayerName();

    String getCreateDate();

    void close();
}
