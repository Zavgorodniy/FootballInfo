package com.zavgorodniy.footballinfo.view.views;

import com.zavgorodniy.footballinfo.model.Season;

import java.util.List;

public interface SeasonsView extends MvpView{
    void setData(List<Season> list);
}
