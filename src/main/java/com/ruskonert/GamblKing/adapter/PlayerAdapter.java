package com.ruskonert.GamblKing.adapter;

import com.google.gson.*;
import com.ruskonert.GamblKing.entity.Player;
import com.ruskonert.GamblKing.framework.PlayerEntityFramework;
import com.ruskonert.GamblKing.framework.RoomFramework;

import java.lang.reflect.Type;

public class PlayerAdapter implements JsonSerializer<Player>, JsonDeserializer<Player>
{
    @Override
    public Player deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = (JsonObject)json;
        PlayerEntityFramework entityFramework = new PlayerEntityFramework();
        entityFramework.setDefeat(object.get("defeat").getAsInt());
        entityFramework.setVictory(object.get("victory").getAsInt());
        entityFramework.setId(object.get("id").getAsString());
        entityFramework.setNickname(object.get("nickname").getAsString());
        entityFramework.setLastBattlePlayer(object.get("lastBattlePlayer").getAsString());
        entityFramework.setHostAddress(object.get("hostAddress").getAsString());
        entityFramework.setLastConnected(object.get("lastConnected").getAsString());
        entityFramework.setPassword(object.get("password").getAsString());

        RoomFramework framework = new Gson().fromJson(object.get("enteredRoom").getAsString(), RoomFramework.class);
        entityFramework.setEnteredRoom(framework);
        return entityFramework;
    }

    @Override
    public JsonElement serialize(Player src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject element = new JsonObject();
        element.addProperty("id", src.getId());
        element.addProperty("nickname", src.getNickname());
        element.addProperty("password", src.getPassword());
        element.addProperty("victory", src.getVictory());
        element.addProperty("defeat", src.getDefeated());
        element.addProperty("lastConnected", src.getLastConnected());
        element.addProperty("lastBattlePlayer", src.getLastBattlePlayer());
        element.addProperty("hostAddress", src.getHostAddress());

        RoomFramework framework = src.getEnteredRoom();

        element.addProperty("enteredRoom", framework == null ? null : new Gson().toJson(framework));
        return element;
    }
}
