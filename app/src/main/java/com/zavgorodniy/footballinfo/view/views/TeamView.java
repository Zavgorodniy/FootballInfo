package com.zavgorodniy.footballinfo.view.views;

import com.zavgorodniy.footballinfo.model.Player;
import com.zavgorodniy.footballinfo.model.Team;

import java.util.List;

public interface TeamView extends MvpView {
    void setTeam(Team list);
    void setPlayers(List<Player> list);
}
