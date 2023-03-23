package edu.ecn.sportuniv;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeuilleMatchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FeuilleMatch feuilleMatch);

    @Query("SELECT * FROM feuillematch_table")
    LiveData<List<FeuilleMatch>> selectAllFeuille();
}
