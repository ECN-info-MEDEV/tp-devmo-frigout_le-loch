package edu.ecn.sportuniv;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UtilisateurViewModel extends AndroidViewModel {
    private UtilisateurRepository mRepository;

    private final LiveData<List<Utilisateur>> mAllUtilisateurs;

    public UtilisateurViewModel (Application application) {
        super(application);
        mRepository = new UtilisateurRepository(application);
        mAllUtilisateurs = mRepository.getAllUtilisateurs();
    }

    LiveData<List<Utilisateur>> getAllWords() { return mAllUtilisateurs; }

    public void insert(Utilisateur user) { mRepository.insert(user); }

    public List<String> checkUser(String user, String password){
        return mRepository.checkUser(user, password);
    }

}
