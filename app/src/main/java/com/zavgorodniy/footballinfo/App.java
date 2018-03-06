package com.zavgorodniy.footballinfo;

import android.app.Application;

import com.zavgorodniy.footballinfo.other.di.components.AppComponent;
import com.zavgorodniy.footballinfo.other.di.components.DaggerAppComponent;
import com.zavgorodniy.footballinfo.other.di.module.AppModule;

public class App extends Application {

    private static AppComponent mComponent;

    public AppComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
