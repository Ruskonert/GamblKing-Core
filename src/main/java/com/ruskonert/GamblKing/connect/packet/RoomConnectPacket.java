package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.adapter.PlayerAdapter;
import com.ruskonert.GamblKing.adapter.RoomAdapter;
import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.entity.Player;
import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.property.ServerProperty;

public class RoomConnectPacket extends Packet {

    private Room room;

    public Room getRoom() {
        return this.room;
    }

    private Player player;

    public Player getPlayer() {
        return this.player;
    }

    private Player leader;

    public Player getLeader() {
        return this.leader;
    }


    public RoomConnectPacket(Player leader, Player player, Room room) {
        super(ServerProperty.ROOM_CONNECTED);
        this.getJsonSerializers().put(Player.class, new PlayerAdapter());
        this.getJsonSerializers().put(Room.class, new RoomAdapter());
        this.player = player;
        this.room = room;
        this.leader = leader;
    }
}
