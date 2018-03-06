package com.zavgorodniy.footballinfo.presenter;

import android.util.Log;

import com.zavgorodniy.footballinfo.view.views.TeamView;
import com.zavgorodniy.footballinfo.other.api.ApiManager;
import com.zavgorodniy.footballinfo.model.response.PlayersResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TeamPresenter extends MvpBasePresenter<TeamView> {
    private static final String TAG = TeamPresenter.class.getName();

    @Inject
    ApiManager mApiManager;

    @Inject
    public TeamPresenter(
            ApiManager apiManager) {
        mApiManager = apiManager;
    }

    public void getPlayers(String teamId) {
        mApiManager.getPlayers(teamId)
                .map(PlayersResponse::getPlayers)
                .flatMap(Observable::fromIterable)
                .toSortedList((player, t1) -> {
                    if (player.getJerseyNumber() > t1.getJerseyNumber())
                        return 1;
                    if (player.getJerseyNumber() < t1.getJerseyNumber())
                        return -1;
                    return 0;
                })
                .subscribe(players -> {
                    if (getView() != null) {
                        getView().hideLoading();
                        getView().setPlayers(players);
                    }
                }, throwable -> {
                    Log.e(TAG, "Error while get players: ", throwable);
                    if (getView() != null) {
                        getView().hideLoading();
                        getView().showError(throwable);
                    }
                });
    }
}
