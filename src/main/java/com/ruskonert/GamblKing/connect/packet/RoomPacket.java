package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.adapter.RoomAdapter;
import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.property.ServerProperty;

public abstract class RoomPacket extends Packet
{
    private Room room;
    public Room getRoom() { return room; }

    public RoomPacket(Room room)
    {
        super(ServerProperty.ROOM_CREATE);
        this.room  = room;
        this.getJsonSerializers().put(Room.class, new RoomAdapter());
    }
}
