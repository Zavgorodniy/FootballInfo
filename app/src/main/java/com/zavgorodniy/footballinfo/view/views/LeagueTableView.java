package com.zavgorodniy.footballinfo.view.views;

import com.zavgorodniy.footballinfo.model.Season;
import com.zavgorodniy.footballinfo.model.Team;

import java.util.List;

public interface LeagueTableView extends MvpView{

    void setTable(List<Team> list);
    void setCompetitionData(Season competitions);
}
