package com.zavgorodniy.footballinfo.other.di.components;

import com.zavgorodniy.footballinfo.other.di.module.ActivityModule;
import com.zavgorodniy.footballinfo.other.di.module.FragmentModule;
import com.zavgorodniy.footballinfo.view.activity.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    FragmentComponent providesFragmentComponent(FragmentModule fragmentModule);

    void inject(MainActivity mainActivity);
}
