package edu.ecn.sportuniv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CompetitionViewHolder extends RecyclerView.ViewHolder {
    private final TextView competitionItemView;
    private final TextView competitionItemNomView;
    private final TextView competitionItemLieuView;
    private final TextView competitionItemHoraireView;

    private CompetitionViewHolder(View itemView) {
        super(itemView);
        competitionItemView = itemView.findViewById(R.id.competition_date);
        competitionItemNomView = itemView.findViewById(R.id.competition_nom);
        competitionItemLieuView = itemView.findViewById(R.id.competition_lieu);
        competitionItemHoraireView = itemView.findViewById(R.id.competition_horaire);
    }

    public void bind(String date,
                     String nom,
                     String lieu,
                     String debut,
                     String fin) {
        String horaire = debut + " - " + fin;
        competitionItemView.setText(date);
        competitionItemNomView.setText(nom);
        competitionItemLieuView.setText(lieu);
        competitionItemHoraireView.setText(horaire);
    }

    static CompetitionViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_competition_item, parent, false);
        return new CompetitionViewHolder(view);
    }
}