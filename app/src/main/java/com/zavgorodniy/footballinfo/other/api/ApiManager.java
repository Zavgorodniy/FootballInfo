package com.zavgorodniy.footballinfo.other.api;

import android.content.Context;

import com.zavgorodniy.footballinfo.model.Season;
import com.zavgorodniy.footballinfo.model.response.LeagueTableResponse;
import com.zavgorodniy.footballinfo.model.response.PlayersResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ApiManager {

    private Context mContext;
    private ApiService mApiService;

    @Inject
    public ApiManager(Context context, ApiService apiService) {
        mContext = context;
        mApiService = apiService;
    }

    private <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<List<Season>> getSoccerSeasons() {
        return mApiService.getSoccerSeasons()
                .compose(applySchedulers());
    }

    public Observable<LeagueTableResponse> getLeagueTable(int competitions) {
        return mApiService.getLeagueTable(competitions)
                .compose(applySchedulers());
    }

    public Observable<Season> getCompetitionById(int competitions) {
        return mApiService.getCompetition(competitions)
                .compose(applySchedulers());
    }

    public Observable<PlayersResponse> getPlayers(String teem) {
        return mApiService.getPlayers(teem)
                .compose(applySchedulers());
    }
}
