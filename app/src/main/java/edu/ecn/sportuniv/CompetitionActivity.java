package edu.ecn.sportuniv;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CompetitionActivity extends AppCompatActivity {

    private CompetitionViewModel mCompetitionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        final CompetitionListeAdapter adapter = new CompetitionListeAdapter(new CompetitionListeAdapter.CompetitionDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CompetitionRepository mCompetitionRepository = new CompetitionRepository(this.getApplication());
        mCompetitionViewModel = new ViewModelProvider(this).get(CompetitionViewModel.class);
        mCompetitionViewModel.getAllCompetition().observe(this, adapter::submitList);

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
