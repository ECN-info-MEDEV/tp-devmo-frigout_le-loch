package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FeuilleRepository {
    private FeuilleMatchDao mFeuilleDao;

    private LiveData<List<FeuilleMatch>> mAllFeuille;

    FeuilleRepository(Application application){
        FeuilleRoomDatabase db = FeuilleRoomDatabase.getDatabase(application);
        mFeuilleDao = db.feuilleMatchDao();
        mAllFeuille = mFeuilleDao.selectAllFeuille();
    }

    LiveData<List<FeuilleMatch>> selectAllFeuille() {
        return mAllFeuille;
    }

    void insert(FeuilleMatch feuilleMatch) {
        UtilisateurRoomDatabase.databaseWriteExecutor.execute(() -> {
            mFeuilleDao.insert(feuilleMatch);
        });
    }
}
