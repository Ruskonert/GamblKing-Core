package com.ruskonert.GamblKing.connect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;
import com.ruskonert.GamblKing.util.SystemUtil;
import javafx.scene.control.Alert;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.SocketException;
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

    public void send(OutputStream stream)
    {
        this.send(new DataOutputStream(stream), this);
    }

    public void send(DataOutputStream stream)
    {
        this.send(stream, this);
    }

    public void send(DataOutputStream stream, Object handleInstance)
    {
        GsonBuilder builder = new GsonBuilder().serializeNulls();
        if(jsonSerializers.keySet().size() != 0) {
            for (Type t : jsonSerializers.keySet()) {
                builder.registerTypeAdapter(t, jsonSerializers.get(t));
            }
        }

        Gson gson = builder.create();

        try
        {
            stream.writeUTF(gson.toJson(handleInstance));
        }
        catch(SocketException e2)
        {
            if(e2.getMessage().equalsIgnoreCase("Broken pipe (Write failed)"))
            {
                this.exit(stream);
                throw new RuntimeException("클라이언트가 강제로 종료되었습니다.");

            }
        }
        catch(NullPointerException | IOException e)
        {
                e.printStackTrace();
                SystemUtil.Companion.alert("이벤트 핸들링 실패", "연결이 끊겨있음",
                        "알수 없는 오류", Alert.AlertType.ERROR);
        }
    }

    public void exit(DataOutputStream stream)
    {

    }

}
