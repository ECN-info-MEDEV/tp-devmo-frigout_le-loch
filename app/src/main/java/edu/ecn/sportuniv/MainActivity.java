package edu.ecn.sportuniv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText userEditText;
    private EditText passwordEditText;
    public static final String EXTRA_USER = "edu.ecn.sportuniv.extra.USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.userEditText = findViewById(R.id.editTextUsername);
        this.passwordEditText = findViewById(R.id.editTextPassword);
    }

    public void checkUser(View view){

        Intent intent = new Intent(this, AccueilActivity.class);
        String user = userEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        UtilisateurRepository utilisateurRepository = new UtilisateurRepository(this.getApplication());
        List<String> results = utilisateurRepository.checkUser(user, password);

        if (results.size() == 0){
            // Si l'utilisateur n'existe pas
            Toast.makeText(getApplicationContext(), "Nom d'utilisateur ou mdp incorrect !", Toast.LENGTH_SHORT).show();
        } else {
            // Si l'utilisateur existe, on start la nouvelle activité et on passe le nom de l'utilisateur
            String nom = results.get(0);
            intent.putExtra(EXTRA_USER, nom);
            startActivity(intent);
        }
    }
}