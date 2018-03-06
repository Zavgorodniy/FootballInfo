package com.zavgorodniy.footballinfo.view.views;

public interface MvpView {
    void showLoading();
    void hideLoading();
    void showError(Throwable error);
}
