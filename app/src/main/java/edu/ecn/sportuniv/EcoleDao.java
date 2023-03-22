package edu.ecn.sportuniv;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface EcoleDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Ecole ecole);

    @Query("DELETE FROM ecole_table")
    void deleteAll();

    @Query("SELECT * FROM ecole_table ORDER BY idEcole ASC")
    LiveData<List<Ecole>> getAlphabetizedWords();
}