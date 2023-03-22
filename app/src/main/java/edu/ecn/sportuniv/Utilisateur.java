package edu.ecn.sportuniv;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "utilisateur_table")
public class Utilisateur {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private Integer idUtilisateur;

    @ColumnInfo(name="nom")
    private String nom;

    @ColumnInfo(name="prenom")
    private String prenom;

    @ColumnInfo(name="user")
    private String user;

    @ColumnInfo(name="mot de passe")
    private String mdp;

    public Utilisateur(@NonNull Integer idUtisateur, String nom, String prenom, String user, String mdp ){
        this.idUtilisateur = idUtisateur;
        this.nom = nom ;
        this.prenom = prenom ;
        this.user = user ;
        this.mdp = mdp ;
    }

    public Utilisateur(String nom, String prenom, String user, String mdp ){
        this.nom = nom ;
        this.prenom = prenom ;
        this.user = user ;
        this.mdp = mdp ;
    }

    @NonNull
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUser() {
        return user;
    }

    public String getMdp() {
        return mdp;
    }
}


