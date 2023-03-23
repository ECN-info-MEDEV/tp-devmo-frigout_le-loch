package edu.ecn.sportuniv;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface CompetitionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Competition competition);

    @Query("DELETE FROM competition_table")
    void deleteAllCompetitions();

    @Query("SELECT * FROM competition_table ORDER BY date ASC, debut ASC")
    LiveData<List<Competition>> getOrderedCompetitions();

    @Query("DELETE FROM competition_table WHERE competition_table.id = :competition_id ")
    void deleteCompetition(int competition_id);

    @Query("SELECT DISTINCT date FROM competition_table ORDER BY date ASC")
    List<String> getCompetitionDates();

    @Query("SELECT * FROM competition_table WHERE date = :date ORDER BY debut ASC")
    List<Competition> getDailyCompetitions(String date);
}

