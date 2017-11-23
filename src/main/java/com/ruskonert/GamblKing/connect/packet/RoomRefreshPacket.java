package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.property.ServerProperty;

public class RoomRefreshPacket extends Packet
{
    private Room[] receivedRoom;
    public Room[] getReceivedRoom() { return this.receivedRoom; }
    public RoomRefreshPacket(Room[] list) {
        super(ServerProperty.ROOM_REFRESH);
    }
}
