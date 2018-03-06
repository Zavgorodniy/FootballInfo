package com.zavgorodniy.footballinfo.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zavgorodniy.footballinfo.R;
import com.zavgorodniy.footballinfo.other.OnAdapterClickListener;
import com.zavgorodniy.footballinfo.model.Season;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<Season> mItems;
    private OnAdapterClickListener mListener;

    public CompetitionsAdapter() {

    }

    public void setItems(List<Season> mItems) {
        this.mItems = mItems;
        notifyDataSetChanged();
    }

    public void setListener(OnAdapterClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_season, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Season currentItem = mItems.get(position);
        holder.seasonTitle.setText(currentItem.getLeague());
        holder.nameTextView.setText(currentItem.getCaption());
        holder.mParentLayout.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onClick(view, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.season_title)
        TextView seasonTitle;
        @BindView(R.id.item_chat_name_text_view)
        TextView nameTextView;
        @BindView(R.id.item_chat_parent_layout)
        LinearLayout mParentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
