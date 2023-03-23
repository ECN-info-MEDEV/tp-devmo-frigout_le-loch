package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CompetitionRepository {
    private CompetitionDao mCompetitionDao;
    private LiveData<List<Competition>> mAllCompetitions;

    CompetitionRepository(Application application) {
        CompetitionRoomDatabase db = CompetitionRoomDatabase.getDatabase(application);
        mCompetitionDao = db.competitionDao();
        mAllCompetitions = mCompetitionDao.getOrderedCompetitions();
    }

    LiveData<List<Competition>> getAllCompetitions() {
        return mAllCompetitions;
    }

    void insert(Competition competition) {
        CompetitionRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCompetitionDao.insert(competition);
        });
    }

    List<String> getCompetitionDates(){
        return  mCompetitionDao.getCompetitionDates();
    }

    List<Competition> getDailyCompetitions(String date){
        return  mCompetitionDao.getDailyCompetitions(date);
    }
}
