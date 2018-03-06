package com.zavgorodniy.footballinfo.presenter;

import com.zavgorodniy.footballinfo.view.views.MvpView;

public interface MvpPresenter<V extends MvpView> {

    public void attachView(V view);

    public void detachView(boolean retainInstance);
}
