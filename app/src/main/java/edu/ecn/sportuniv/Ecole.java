package edu.ecn.sportuniv;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Classe permettant de représenter une Ecole dans la base de données.
 * @author Antoine FRIGOUT [antoine.frigout@eleves.ec-nantes.fr]
 * @author Maïlys LE LOCH [mailys.le-loch@eleves.ec-nantes.fr]
 * @version 0.1
 */
@Entity(tableName = "ecole_table")
public class Ecole {

    @NonNull
    @ColumnInfo(name = "idEcole")
    @PrimaryKey(autoGenerate = true)
    private Integer idEcole;

    @NonNull
    @ColumnInfo(name = "nom")
    private String nom;

    @NonNull
    @ColumnInfo(name = "logo")
    private String uriLogo;

    /**
     * Constructeur de la classe Ecole.
     *
     * @param nom Le nom de l'école
     * @param uriLogo Le lien vers le logo de l'école
     */
    public Ecole(@NonNull String nom,
                 @NonNull String uriLogo){
        this.nom = nom;
        this.uriLogo = uriLogo;
    }

    /**
     * Constructeur de la classe Ecole.
     *
     * @param idEcole L'identifiant unqiue de l'école
     * @param nom Le nom de l'école
     * @param uriLogo Le lien vers le logo de l'école
     */
    @Ignore
    public Ecole(@NonNull Integer idEcole,
                 @NonNull String nom,
                 @NonNull String uriLogo){
        this.idEcole = idEcole;
        this.nom = nom;
        this.uriLogo = uriLogo;
    }

    public Integer getIdEcole() {
        return idEcole;
    }

    public String getNom() {
        return nom;
    }

    public String getUriLogo() {
        return uriLogo;
    }

    public void setIdEcole(@NonNull Integer idEcole) {
        this.idEcole = idEcole;
    }

    public void setNom(@NonNull String nom) {
        this.nom = nom;
    }

    public void setUriLogo(@NonNull String uriLogo) {
        this.uriLogo = uriLogo;
    }
}
