package com.zavgorodniy.footballinfo.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zavgorodniy.footballinfo.App;
import com.zavgorodniy.footballinfo.other.di.components.ActivityComponent;
import com.zavgorodniy.footballinfo.other.di.components.AppComponent;
import com.zavgorodniy.footballinfo.other.di.module.ActivityModule;
import com.zavgorodniy.footballinfo.presenter.MvpPresenter;
import com.zavgorodniy.footballinfo.view.views.MvpView;

import butterknife.ButterKnife;
import lombok.Getter;
import lombok.experimental.Accessors;

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity {

    @Getter
    @Accessors(prefix = "m")
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mActivityComponent = getApplicationComponent().providesActivityComponent(new ActivityModule(this));
        injectDependencies();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
    }


    public abstract void injectDependencies();

    public abstract int getLayoutRes();

    AppComponent getApplicationComponent() {
        return ((App) getApplication()).getComponent();
    }
}
