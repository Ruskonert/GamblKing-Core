package com.ruskonert.GamblKing.connect;

import com.ruskonert.GamblKing.util.SystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import javafx.scene.control.Alert;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class Packet
{
    private transient Map<Type, JsonSerializer<?>> jsonSerializers = new HashMap<>();
    public Map<Type, JsonSerializer<?>> getJsonSerializers() { return this.jsonSerializers; }

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
        GsonBuilder builder = new GsonBuilder().serializeNulls();
        if(jsonSerializers.keySet().size() != 0)
            for(Type t : jsonSerializers.keySet())
            {
                builder.registerTypeAdapter(t, jsonSerializers.get(t));
            }

        Gson gson = builder.create();

        try
        {
            stream.writeUTF(gson.toJson(handleInstance));
        }
        catch(NullPointerException | IOException e)
        {
            e.printStackTrace();
            SystemUtil.Companion.alert("이벤트 핸들링 실패", "연결이 끊겨있음",
                    "서버가 닫혀있거나 연결되지 않았습니다.", Alert.AlertType.ERROR);
        }
    }
}
