package com.zavgorodniy.footballinfo.presenter;

import com.zavgorodniy.footballinfo.view.views.SeasonsView;
import com.zavgorodniy.footballinfo.other.api.ApiManager;

import javax.inject.Inject;

public class SeasonsPresenter extends MvpBasePresenter<SeasonsView> {

    @Inject
    ApiManager mApiManager;

    @Inject
    public SeasonsPresenter(
            ApiManager apiManager) {
        mApiManager = apiManager;
    }

    public void getSeasons() {
        mApiManager.getSoccerSeasons().subscribe(conversationResponse -> {
            if (getView() != null) {
                getView().hideLoading();
                getView().setData(conversationResponse);
            }
        }, throwable -> {
            if (getView() != null) {
                getView().hideLoading();
                getView().showError(throwable);
            }
        });
    }

}
