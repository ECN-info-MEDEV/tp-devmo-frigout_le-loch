package edu.ecn.sportuniv;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.util.Date;

@Entity(tableName = "competition_table")
public class Competition {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private Integer idCompetition;

    @ColumnInfo(name="date")
    private String date;

    @ColumnInfo(name="debut")
    private String debut;

    @ColumnInfo(name="fin")
    private String fin;

    @ColumnInfo(name="nom")
    private String nom;

    @ColumnInfo(name="lieu")
    private String lieu;

    public Competition(String date,
                       String debut,
                       String fin,
                       String nom,
                       String lieu) {
        this.date = date;
        this.debut = debut;
        this.fin = fin;
        this.nom = nom;
        this.lieu = lieu;
    }

    @NonNull
    public Integer getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(@NonNull Integer idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}


