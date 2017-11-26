package com.ruskonert.GamblKing.adapter;

import com.google.gson.*;
import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.framework.RoomFramework;

import java.lang.reflect.Type;

public class RoomAdapter implements JsonSerializer<Room>, JsonDeserializer<Room>
{
    @Override
    public Room deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {

        JsonObject object = (JsonObject)json;
        RoomFramework framework = (RoomFramework)RoomFramework.generate(object.get("leaderName").getAsString(), object.get("name").getAsString());
        framework.setWaitPlayer(object.get("waitPlayerName").getAsString());
        framework.setCreateDate(object.get("createDate").getAsString());
        return framework;
    }

    @Override
    public JsonElement serialize(Room src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject object = new JsonObject();
        object.addProperty("leaderName", src.getLeaderName());
        object.addProperty("waitPlayerName", src.getWaitPlayerName());
        object.addProperty("name", src.getName());
        object.addProperty("createDate", src.getCreateDate());
        return object;
    }
}
