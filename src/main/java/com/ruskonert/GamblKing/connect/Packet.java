package com.ruskonert.GamblKing.connect;

import com.google.gson.Gson;
import com.ruskonert.GamblKing.util.SystemUtil;
import javafx.scene.control.Alert;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Packet
{
    private int status;
    public int getStatus() { return this.status; }

    public Packet(int status)
    {
        this.status = status;
    }

    public void send(DataOutputStream stream)
    {
        this.send(stream, this);
    }

    public void send(DataOutputStream stream, Object handleInstance)
    {
        Gson gson = new Gson();
        try
        {
            stream.writeUTF(gson.toJson(handleInstance));
        }
        catch(NullPointerException | IOException e)
        {
            SystemUtil.Companion.alert("이벤트 핸들링 실패", "연결이 끊겨있음",
                    "서버가 닫혀있거나 연결되지 않았습니다.", Alert.AlertType.ERROR);
        }
    }
}
