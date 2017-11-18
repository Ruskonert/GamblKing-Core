package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.entity.Player;
import com.ruskonert.GamblKing.property.ServerProperty;

public abstract class GameConnectionPacket extends Packet
{
    private Player player;
    public Player getPlayer() { return this.player; }

    public GameConnectionPacket(Player player)
    {
        super(ServerProperty.CONNECT_GAME_SERVER);
        this.player = player;
    }
}
