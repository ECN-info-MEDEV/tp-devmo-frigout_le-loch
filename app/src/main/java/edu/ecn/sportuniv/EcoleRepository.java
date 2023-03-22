package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EcoleRepository {
    private EcoleDao mEcoleDao;
    private LiveData<List<Ecole>> mAllEcole;

    EcoleRepository(Application application) {
        EcoleRoomDatabase db = EcoleRoomDatabase.getDatabase(application);
        mEcoleDao = db.ecoleDao();
        mAllEcole = mEcoleDao.getAlphabetizedWords();
    }

    LiveData<List<Ecole>> getAllWords() {
        return mAllEcole;
    }

    void insert(Ecole ecole) {
        EcoleRoomDatabase.databaseWriteExecutor.execute(() -> {
            mEcoleDao.insert(ecole);
        });
    }

}
