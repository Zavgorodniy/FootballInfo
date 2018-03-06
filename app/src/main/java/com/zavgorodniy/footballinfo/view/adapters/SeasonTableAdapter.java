package com.zavgorodniy.footballinfo.view.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zavgorodniy.footballinfo.R;
import com.zavgorodniy.footballinfo.other.OnAdapterClickListener;
import com.zavgorodniy.footballinfo.model.Team;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeasonTableAdapter extends RecyclerView.Adapter<SeasonTableAdapter.ViewHolder> {

    private List<Team> mItems;
    private OnAdapterClickListener mListener;
    private Context mContext;

    public SeasonTableAdapter(Context context) {
        this.mContext = context;
    }

    public void setItems(List<Team> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    public void setListener(OnAdapterClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public SeasonTableAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SeasonTableAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false));
    }

    @Override
    public void onBindViewHolder(SeasonTableAdapter.ViewHolder holder, int position) {
        Team currentItem = mItems.get(position);
        holder.nameTextView.setText(currentItem.getTeamName());

        fillText(holder.gp, currentItem.getPlayedGames());
        fillText(holder.w, currentItem.getWins());
        fillText(holder.d, currentItem.getDraws());
        fillText(holder.l, currentItem.getLosses());
        fillText(holder.f, currentItem.getGoals());
        fillText(holder.a, currentItem.getGoalsAgainst());
        fillText(holder.gd, currentItem.getGoalDifference());
        fillText(holder.pts, currentItem.getPoints());

        holder.parentLayout.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onClick(view, position);
            }
        });
    }

    private void fillText(TextView tv, int value) {
        if (tv != null) {
            tv.setText(String.valueOf(value));
        }
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_team_parent_layout)
        LinearLayout parentLayout;
        @BindView(R.id.item_title)
        TextView nameTextView;

        @BindView(R.id.gp_content)
        TextView gp;
        @BindView(R.id.w_content)
        TextView w;
        @BindView(R.id.d_content)
        TextView d;
        @BindView(R.id.l_content)
        TextView l;
        @BindView(R.id.f_content)
        TextView f;
        @BindView(R.id.a_content)
        TextView a;
        @BindView(R.id.gd_content)
        TextView gd;
        @BindView(R.id.pts_content)
        TextView pts;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
