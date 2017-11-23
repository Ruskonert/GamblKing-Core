package com.ruskonert.GamblKing.entity;

public interface Room
{
    String getName();

    Player getLeader();

    Player getWaitPlayer();

    String getCreateDate();

    void close();
}
