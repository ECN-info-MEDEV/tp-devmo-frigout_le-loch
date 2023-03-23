package edu.ecn.sportuniv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "edu.ecn.sportuniv.extra.USER";
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        Intent intent = getIntent();
        this.userName = intent.getStringExtra(MainActivity.EXTRA_USER);
        TextView textView = findViewById(R.id.accueil_welcomeText);
        String welcomeText = "BIENVENU " + this.userName.toUpperCase();
        textView.setText(welcomeText);
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
}
