package com.zavgorodniy.footballinfo.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;

import com.zavgorodniy.footballinfo.R;
import com.zavgorodniy.footballinfo.presenter.MainActivityPresenter;
import com.zavgorodniy.footballinfo.view.views.MainActivityView;
import com.zavgorodniy.footballinfo.view.fragments.SeasonsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainActivityView, MainActivityPresenter> {

    @BindView(R.id.activity_main_team_container)
    RelativeLayout mTeamContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            replaceFragment(SeasonsFragment.newInstance());
        }
    }

    @Override
    public void onBackPressed() {
        if (mTeamContainer.getVisibility() == View.VISIBLE) {
            removeTeamFragment();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main_container, fragment)
                .addToBackStack(fragment.getTag())
                .commit();
    }

    public void addTeamFragment(Fragment fragment) {
        mTeamContainer.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main_team_container, fragment)
                .commit();
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, fragment)
                .commitAllowingStateLoss();
    }

    public void removeTeamFragment() {
        mTeamContainer.setVisibility(View.GONE);
    }
}
