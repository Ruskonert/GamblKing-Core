package com.ruskonert.GamblKing.entity;


public interface PlayerEntity
{
    String getId();

    String getNickname();

    String getPassword();

    int getVictory();

    int getDefeated();

    String getLastConnected();

    String getLastBattlePlayer();

    String getHostAddress();
}
