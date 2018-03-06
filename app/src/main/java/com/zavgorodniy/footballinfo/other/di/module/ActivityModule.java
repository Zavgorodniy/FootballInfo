package com.zavgorodniy.footballinfo.other.di.module;

import com.zavgorodniy.footballinfo.view.activity.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;

@Module
public class ActivityModule {
    private WeakReference<BaseActivity> mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = new WeakReference<>(activity);
    }
}
