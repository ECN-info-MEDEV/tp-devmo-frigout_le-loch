package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CompetitionViewModel extends AndroidViewModel {
    private CompetitionRepository mRepository;

    private final LiveData<List<Competition>> mAllCompetition;

    public CompetitionViewModel (Application application) {
        super(application);
        mRepository = new CompetitionRepository(application);
        mAllCompetition = mRepository.getAllCompetitions();
    }

    LiveData<List<Competition>> getAllCompetition() { return mAllCompetition; }

    public void insert(Competition competition) { mRepository.insert(competition); }

    public List<String> listeDates(){
        return mRepository.getCompetitionDates();
    }

    public List<Competition> dailyListe(String date){
        return mRepository.getDailyCompetitions(date);
    }

}
