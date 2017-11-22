package com.ruskonert.GamblKing.entity;

public interface Player extends PlayerEntity, MessageDispatcher
{
    boolean isEnteredRoom();
}
