package edu.ecn.sportuniv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CompetitionViewHolder extends RecyclerView.ViewHolder {
    private final TextView competitionItemView;

    private CompetitionViewHolder(View itemView) {
        super(itemView);
        competitionItemView = itemView.findViewById(R.id.competition_date);
    }

    public void bind(String text) {
        competitionItemView.setText(text);
    }

    static CompetitionViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_competition_item, parent, false);
        return new CompetitionViewHolder(view);
    }
}