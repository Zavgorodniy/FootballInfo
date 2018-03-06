package com.zavgorodniy.footballinfo.view.adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zavgorodniy.footballinfo.R;
import com.zavgorodniy.footballinfo.model.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private List<Player> mItems;

    public PlayerAdapter() {
    }

    public void setItems(List<Player> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayerAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayerAdapter.ViewHolder holder, int position) {
        Player currentItem = mItems.get(position);
        fillName(holder.nameTextView, currentItem.getName(), currentItem.getPosition());
        holder.jerseyName.setText(String.valueOf(currentItem.getJerseyNumber()));
        holder.nationality.setText(currentItem.getNationality());
    }

    @SuppressLint("DefaultLocale")
    private void fillName(TextView tv, String name, String position) {
        if (position != null && position.length() > 0) {
            String text = name + "(" + position + ")";
            tv.setText(text);
        } else {
            tv.setText(name);
        }
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_player_name_text_view)
        TextView nameTextView;
        @BindView(R.id.item_player_parent_layout)
        LinearLayout mParentLayout;
        @BindView(R.id.item_player_jersey_text)
        TextView jerseyName;
        @BindView(R.id.item_player_nationality_text_view)
        TextView nationality;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
