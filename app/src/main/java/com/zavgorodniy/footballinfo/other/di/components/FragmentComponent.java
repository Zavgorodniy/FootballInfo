package com.zavgorodniy.footballinfo.other.di.components;

import com.zavgorodniy.footballinfo.other.di.module.FragmentModule;
import com.zavgorodniy.footballinfo.view.fragments.LeagueTableFragment;
import com.zavgorodniy.footballinfo.view.fragments.SeasonsFragment;
import com.zavgorodniy.footballinfo.view.fragments.TeamFragment;

import dagger.Subcomponent;

@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(SeasonsFragment chatListFragment);

    void inject(LeagueTableFragment leagueTableFragment);

    void inject(TeamFragment teamFragment);
}
