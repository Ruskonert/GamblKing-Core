package com.ruskonert.GamblKing.adapter;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ruskonert.GamblKing.entity.Player;
import com.ruskonert.GamblKing.entity.Room;
import com.ruskonert.GamblKing.framework.PlayerEntityFramework;
import com.ruskonert.GamblKing.framework.RoomFramework;

import java.lang.reflect.Type;

public class RoomAdapter implements JsonSerializer<Room>, JsonDeserializer<Room>
{
    @Override
    public Room deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject object = (JsonObject) json;
        Player player = new GsonBuilder().registerTypeAdapter(Player.class,
                new PlayerAdapter()).create().fromJson(object.get("player").getAsString(), PlayerEntityFramework.class);
        return RoomFramework.generate(player, object.get("name").getAsString());
    }

    @Override
    public JsonElement serialize(Room src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject object = new JsonObject();
        object.addProperty("player", new GsonBuilder().registerTypeAdapter(Player.class, new PlayerAdapter()).create().toJson(src.getLeader()));
        object.addProperty("name", src.getName());
        return object;
    }
}
