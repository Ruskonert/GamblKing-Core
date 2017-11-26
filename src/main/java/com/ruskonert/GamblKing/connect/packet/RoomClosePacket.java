package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.property.ServerProperty;

public class RoomClosePacket extends Packet
{
    private boolean isLeader;

    public RoomClosePacket(boolean isLeader)
    {
        super(ServerProperty.ROOM_CLOSE);
        this.isLeader = isLeader;
    }
}
