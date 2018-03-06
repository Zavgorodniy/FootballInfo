package com.zavgorodniy.footballinfo.presenter;

import android.util.Log;

import com.zavgorodniy.footballinfo.view.views.LeagueTableView;
import com.zavgorodniy.footballinfo.other.api.ApiManager;

import javax.inject.Inject;

public class LeagueTablePresenter extends MvpBasePresenter<LeagueTableView> {
    private static final String TAG = LeagueTablePresenter.class.getName();

    @Inject
    ApiManager mApiManager;

    @Inject
    public LeagueTablePresenter(
            ApiManager apiManager) {
        mApiManager = apiManager;
    }

    public void getLeagueTable(int competition) {
        mApiManager.getLeagueTable(competition)
                .subscribe(leagueTableResponse -> {
                    if (getView() != null) {
                        getView().hideLoading();
                        getView().setTable(leagueTableResponse.getTeamsStanding());
                    }
                }, throwable -> {
                    Log.e(TAG, "Error while load table: ", throwable);
                    if (getView() != null) {
                        getView().hideLoading();
                        getView().showError(throwable);
                    }
                });
    }

    public void getCompetitionData(int competition) {
        mApiManager.getCompetitionById(competition)
                .subscribe(competitions -> {
                            if (getView() != null) {
                                getView().hideLoading();
                                getView().setCompetitionData(competitions);
                            }
                        }, throwable ->
                                Log.e(TAG, "Error while get competition data: ", throwable)
                );
    }
}
