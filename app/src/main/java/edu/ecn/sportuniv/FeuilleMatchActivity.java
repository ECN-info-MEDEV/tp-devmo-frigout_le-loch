package edu.ecn.sportuniv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FeuilleMatchActivity extends AppCompatActivity {

    // Variable feuille match
    private EditText sport;
    private CheckBox masculin;
    private CheckBox feminin;
    private EditText date;
    private EditText heure;
    private EditText lieu;
    private EditText nomEquipe;
    private EditText nomJoueur;
    private EditText numeroFFSU;
    private EditText nomCapitaine;
    private EditText nomArbitre;
    private EditText adresseArbitre;

    private ArrayList<String> listeEquipe;

    private ArrayList<String> listeJoueur;

    private ArrayList<String> listeArbitre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feuillematch);
        this.feminin = findViewById(R.id.checkBox);
        this.masculin = findViewById(R.id.checkBox2);
        this.date = findViewById(R.id.editTextDate);
        this.heure = findViewById(R.id.editTextTime);
        this.lieu = findViewById(R.id.editTextTextPersonName2);
        this.nomEquipe = findViewById(R.id.editTextTextPersonName7);
        this.nomJoueur = findViewById(R.id.editTextTextPersonName10);
        this.numeroFFSU = findViewById(R.id.editTextTextPersonName3);
        this.nomCapitaine = findViewById(R.id.editTextTextPersonName4);
        this.nomArbitre = findViewById(R.id.editTextTextPersonName6);
        this.adresseArbitre = findViewById(R.id.editTextTextPersonName11);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_competitions_feuille:
                Intent intentFeuille = new Intent(this, FeuilleMatchActivity.class);
                startActivity(intentFeuille);
                return true;
            case R.id.menu_competitions_planning:
                Intent intentPlanning = new Intent(this, CompetitionActivity.class);
                startActivity(intentPlanning);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addFeuille(View view){
        FeuilleMatch  feuille;
        feuille = new FeuilleMatch();

        String lieu = this.lieu.getText().toString().trim();
        feuille.setLieu(lieu);

        Boolean masculin = this.masculin.isChecked();
        feuille.setGenreMasculin(masculin);

        Boolean feminin = this.feminin.isChecked();
        feuille.setGenreFeminin(feminin);

        String date = this.date.getText().toString().trim();
        String heure = this.heure.getText().toString().trim();

        feuille.setListeArbitre(this.listeArbitre);
        feuille.setListeEquipe(this.listeEquipe);
        feuille.setListeJoueurs(this.listeJoueur);

        FeuilleRepository feuilleRepository = new FeuilleRepository(this.getApplication());
        feuilleRepository.insert(feuille);

        //remise à zéro de tous les champs après l'ajout dans la bdd + export
        this.feminin.setText("");
        this.masculin.setText("");
        this.date.setText("");
        this.heure.setText("");
        this.lieu.setText("");
        this.nomEquipe.setText("");
        this.nomJoueur.setText("");
        this.numeroFFSU.setText("");
        this.nomCapitaine.setText("");
        this.nomArbitre.setText("");
        this.adresseArbitre.setText("");

    }

    public void addArbitre(View view){
        String nomArbitre = this.nomArbitre.getText().toString().trim();
        String adresseArbitre = this.adresseArbitre.getText().toString().trim();
        listeArbitre.add(nomArbitre);
        listeArbitre.add(adresseArbitre);
        this.nomArbitre.setText("");
        this.adresseArbitre.setText("");
    }

    public void addJoueur(View view){
        String nomJoueur = this.nomJoueur.getText().toString().trim();
        String numFFSU = this.numeroFFSU.getText().toString().trim();
        listeJoueur.add((nomJoueur));
        listeJoueur.add((numFFSU));
        this.nomJoueur.setText("");
        this.numeroFFSU.setText("");
    }

    public void addEquipe(View view){
        String nomEquipe = this.nomEquipe.getText().toString().trim();
        String capitaine = this.nomCapitaine.getText().toString().trim();
        listeEquipe.add(nomEquipe);
        listeEquipe.add(capitaine);
        this.nomEquipe.setText("");
        this.nomCapitaine.setText("");
    }

}