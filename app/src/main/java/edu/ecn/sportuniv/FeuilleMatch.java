package edu.ecn.sportuniv;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "feuillematch_table")
public class FeuilleMatch {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private Integer idFeuilleMatch;

    @ColumnInfo(name="Sport")
    private String sport;

    @ColumnInfo(name="Genre Masculin")
    private Boolean genreMasculin;

    @ColumnInfo(name="Genre Feminin")
    private Boolean genreFeminin;

    @ColumnInfo(name="Date")
    private String date;

    @ColumnInfo(name="Heure")
    private String heure;

    @ColumnInfo(name="Lieu")
    private String lieu;

    @ColumnInfo(name="Nom Arbitre")
    private String nomArbitre;

    @ColumnInfo(name="Adresse Arbitre")
    private String adresseArbitre;

    @ColumnInfo(name="Nom Joueur")
    private String nomJoueur;

    @ColumnInfo(name="Numero FFSU Joueur")
    private String numeroFfsuJoueur;

    @ColumnInfo(name="Nom Equipe")
    private String nomEquipe;

    @ColumnInfo(name="Liste Equipe")
    private String listeEquipe;

    @ColumnInfo(name="Liste Arbitre")
    private String listeArbitre;

    @ColumnInfo(name="Liste Joueurs")
    private String listeJoueurs;

    public String getListeEquipe() {
        return listeEquipe;
    }

    public void setListeEquipe(String listeEquipe) {
        listeEquipe = listeEquipe;
    }

    public String getListeArbitre() {
        return listeArbitre;
    }

    public void setListeArbitre(String listeArbitre) {
        this.listeArbitre = listeArbitre;
    }

    public String getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(String listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    @NonNull
    public Integer getIdFeuilleMatch() {
        return idFeuilleMatch;
    }

    public void setIdFeuilleMatch(@NonNull Integer idFeuilleMatch) {
        this.idFeuilleMatch = idFeuilleMatch;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Boolean getGenreMasculin() {
        return genreMasculin;
    }

    public void setGenreMasculin(Boolean genre) {
        this.genreMasculin = genre;
    }

    public Boolean getGenreFeminin() {
        return genreFeminin;
    }

    public void setGenreFeminin(Boolean genre) {
        this.genreFeminin = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getNomArbitre() {
        return nomArbitre;
    }

    public void setNomArbitre(String nomArbitre) {
        this.nomArbitre = nomArbitre;
    }

    public String getAdresseArbitre() {
        return adresseArbitre;
    }

    public void setAdresseArbitre(String adresseArbitre) {
        this.adresseArbitre = adresseArbitre;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getNumeroFfsuJoueur() {
        return numeroFfsuJoueur;
    }

    public void setNumeroFfsuJoueur(String numeroFfsuJoueur) {
        this.numeroFfsuJoueur = numeroFfsuJoueur;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getNomCapitaine() {
        return nomCapitaine;
    }

    public void setNomCapitaine(String nomCapitaine) {
        this.nomCapitaine = nomCapitaine;
    }

    @ColumnInfo(name="Nom Capitaine")
    private String nomCapitaine;

    public FeuilleMatch(){
        this.listeEquipe = null ;
        this.listeArbitre = null;
        this.listeJoueurs = null;
        this.sport = "";
        this.genreFeminin = false;
        this.genreMasculin = false;
        this.date = "";
        this.heure = "";
        this.lieu ="";
        this.nomEquipe="";
        this.nomJoueur="";
        this.numeroFfsuJoueur="";
        this.nomCapitaine="";
        this.nomArbitre="";
        this.adresseArbitre="";
    }
}
