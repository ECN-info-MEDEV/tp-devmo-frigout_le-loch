package edu.ecn.sportuniv;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CompetitionListeAdapter extends ListAdapter<Competition, CompetitionViewHolder> {
    public CompetitionListeAdapter(@NonNull DiffUtil.ItemCallback<Competition> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CompetitionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CompetitionViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CompetitionViewHolder holder, int position) {
        Competition current = getItem(position);
        holder.bind(current.getDate());
    }

    static class CompetitionDiff extends DiffUtil.ItemCallback<Competition> {

        @Override
        public boolean areItemsTheSame(@NonNull Competition oldItem, @NonNull Competition newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Competition oldItem, @NonNull Competition newItem) {
            return oldItem.getDate().equals(newItem.getDate());
        }
    }

}
