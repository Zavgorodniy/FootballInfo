package com.zavgorodniy.footballinfo.other.di.components;

import com.zavgorodniy.footballinfo.other.di.module.ActivityModule;
import com.zavgorodniy.footballinfo.other.di.module.ApiModule;
import com.zavgorodniy.footballinfo.other.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, ApiModule.class})
@Singleton
public interface AppComponent {

    ActivityComponent providesActivityComponent(ActivityModule activityModule);

}
