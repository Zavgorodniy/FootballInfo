package com.zavgorodniy.footballinfo.model.response;

import com.google.gson.annotations.SerializedName;
import com.zavgorodniy.footballinfo.model.Team;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class LeagueTableResponse extends Response implements Serializable {
    @SerializedName("leagueCaption")
    String leagueCaption;

    @SerializedName("matchday")
    int matchday;

    @SerializedName("standing")
    List<Team> teamsStanding;
}
