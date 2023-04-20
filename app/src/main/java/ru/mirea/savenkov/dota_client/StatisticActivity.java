package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCellAdapter;

public class StatisticActivity extends AppCompatActivity{
    private RecyclerView enemyHeroesView;
    private RecyclerView allyHeroesView;
    private SelectedHeroCellAdapter enemyHeroesAdapter;
    private SelectedHeroCellAdapter allyHeroesAdapter;
    private TextView totalAdvantage;
    private List<SelectedHeroCell> allyHeroesList;
    private List<SelectedHeroCell> enemyHeroesList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        LinearLayout allyEnemyLayout = findViewById(R.id.allyEnemyLayout);
        enemyHeroesView = allyEnemyLayout.findViewById(R.id.enemyHeroesView).findViewById(R.id.chosenHeroesView);
        allyHeroesView = allyEnemyLayout.findViewById(R.id.allyHeroesView).findViewById(R.id.chosenHeroesView);
        totalAdvantage = allyEnemyLayout.findViewById(R.id.totalAdvantageTextView);

        fillEnemyHeroesView();
        fillAllyHeroesView();
        fillAdvantageTextView();
    }

    private void fillAdvantageTextView() {
        double advantage = getIntent().getDoubleExtra("Advantage", Double.MAX_VALUE);
        if(advantage == Double.MAX_VALUE){
            throw new RuntimeException("Wrong advantage.");
        }
        totalAdvantage.setText(String.valueOf(advantage));
        if (advantage > 0) {
            totalAdvantage.setTextColor(getResources().getColor(R.color.green));
        }
        else if(advantage < 0){
            totalAdvantage.setTextColor(getResources().getColor(R.color.red));
        }
        else{
            totalAdvantage.setTextColor(getResources().getColor(R.color.black));
        }
    }

    private void fillAllyHeroesView() {
        allyHeroesList = (List<SelectedHeroCell>)getIntent().getSerializableExtra(getString(R.string.selectedAllyHeroes));
        allyHeroesAdapter = new SelectedHeroCellAdapter(this, allyHeroesList);
        allyHeroesView.setAdapter(allyHeroesAdapter);
    }

    private void fillEnemyHeroesView() {
        enemyHeroesList = (List<SelectedHeroCell>)getIntent().getSerializableExtra(getString(R.string.selectedEnemyHeroes));
        enemyHeroesAdapter = new SelectedHeroCellAdapter(this, enemyHeroesList);
        enemyHeroesView.setAdapter(enemyHeroesAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.backButton) {
            Intent intent = new Intent(this, CounterpicksActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

            intent.putExtra(getString(R.string.fromClassIntent), getString(R.string.statisticActivityName));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.statistic_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
