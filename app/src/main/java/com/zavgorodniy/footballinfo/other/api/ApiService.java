package com.zavgorodniy.footballinfo.other.api;

import com.zavgorodniy.footballinfo.model.Season;
import com.zavgorodniy.footballinfo.model.response.LeagueTableResponse;
import com.zavgorodniy.footballinfo.model.response.PlayersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {

    @GET("soccerseasons/")
    Observable<List<Season>> getSoccerSeasons();

    @GET("competitions/{teem}/leagueTable/")
    Observable<LeagueTableResponse> getLeagueTable(@Path("teem") int teem);

    @GET("competitions/{id}/")
    Observable<Season> getCompetition(@Path("id") int id);

    @GET("teams/{teem}/players/")
    Observable<PlayersResponse> getPlayers(@Path("teem") String teem);
}