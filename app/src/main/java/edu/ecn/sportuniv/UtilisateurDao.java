package edu.ecn.sportuniv;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UtilisateurDao {

        // allowing the insert of the same word multiple times by passing a
        // conflict resolution strategy
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Utilisateur utilisateur);

        @Query("DELETE FROM utilisateur_table")
        void deleteAllUtilisateur();

        @Query("SELECT * FROM utilisateur_table ORDER BY nom ASC")
        LiveData<List<Utilisateur>> getAlphabetizedUtilisateur();

        @Query("DELETE FROM utilisateur_table WHERE utilisateur_table.id = :utilisateur_id ")
        void deleteUtilisateur(int utilisateur_id);

        @Query("SELECT utilisateur_table.nom FROM utilisateur_table WHERE utilisateur_table.user = :user AND utilisateur_table.`mot de passe` = :password")
        List<String> checkUser(String user, String password);


    }

