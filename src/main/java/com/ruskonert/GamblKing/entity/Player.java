package com.ruskonert.GamblKing.entity;

import com.ruskonert.GamblKing.framework.RoomFramework;

public interface Player extends PlayerEntity, MessageDispatcher
{
    RoomFramework getEnteredRoom();

    boolean isEnteredRoom();
}
