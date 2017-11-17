package com.ruskonert.GamblKing.connect.packet;

import com.ruskonert.GamblKing.connect.Packet;
import com.ruskonert.GamblKing.property.ServerProperty;

public class RegisterConnectionPacket extends Packet
{
    private String id;
    public String getId() { return id; }

    private String nickname;
    public String getNickname() { return nickname; }

    private String password;
    public String getPassword() { return password; }

    public RegisterConnectionPacket(String id, String nickname, String password)
    {
        super(ServerProperty.CHECK_REGISTER_CONNECTION);
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }
}
