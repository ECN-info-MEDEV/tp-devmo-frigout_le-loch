package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UtilisateurRepository {
    private UtilisateurDao mUtilisateurDao;
    private LiveData<List<Utilisateur>> mAllUtilisateurs;

    UtilisateurRepository(Application application) {
        UtilisateurRoomDatabase db = UtilisateurRoomDatabase.getDatabase(application);
        mUtilisateurDao = db.utilisateurDao();
        mAllUtilisateurs = mUtilisateurDao.getAlphabetizedUtilisateur();
    }

    LiveData<List<Utilisateur>> getAllUtilisateurs() {
        return mAllUtilisateurs;
    }

    List<String> checkUser(String user, String password) {
        return mUtilisateurDao.checkUser(user, password);
    }

    void insert(Utilisateur user) {
        UtilisateurRoomDatabase.databaseWriteExecutor.execute(() -> {
            mUtilisateurDao.insert(user);
        });
    }


}
