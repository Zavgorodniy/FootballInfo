package com.zavgorodniy.footballinfo.model.response;

import com.google.gson.annotations.SerializedName;
import com.zavgorodniy.footballinfo.model.Player;

import java.util.List;

import lombok.Data;

@Data
public class PlayersResponse {
    @SerializedName("players")
    List<Player> players;
    @SerializedName("count")
    int count;
}
