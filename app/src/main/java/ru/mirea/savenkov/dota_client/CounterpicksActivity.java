package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.heroSelectRow.SingleHeroSelectRow;
import ru.mirea.savenkov.dota_client.heroSelectRow.SingleHeroSelectRowAdapter;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCellAdapter;

public class CounterpicksActivity extends AppCompatActivity {
    private RecyclerView chosenHeroesView;
    private RecyclerView bestCounterpeeksView;
    private SelectedHeroCellAdapter chosenHeroesAdapter;
    private SingleHeroSelectRowAdapter bestCounterpeeksAdapter;
    private DataManager dataManager = DataManager.getInstance();
    private Toolbar toolbar;
    private SearchView searchView;
    private List<SelectedHeroCell> selectedHeroes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counterpicks);

        chosenHeroesView = findViewById(R.id.chosenHeroesView);
        bestCounterpeeksView = findViewById(R.id.counterpeeksView);

        fillChosenHeroesView();
        fillBestCounterpeeksView();
    }

    private void fillBestCounterpeeksView() {
        //1)получить список наилучших контрпиков
        //2)создать адаптер
        //3)разместить их в view
        Set<String> selectedHeroesNamesSet = new HashSet<>();
        for(int i = 0; i < selectedHeroes.size(); i++){
            selectedHeroesNamesSet.add(selectedHeroes.get(i).getHeroName());
        }
        //0)создаём пустой список с героями (124 - n, где n - кол-во выбранных героев)
        List<SingleHeroSelectRow> bestDisadvantages = new ArrayList<>(DotabuffInfo.heroesCount - selectedHeroes.size());
        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            if(!selectedHeroesNamesSet.contains(DotabuffInfo.niceHeroesString.get(i))){
                SingleHeroSelectRow singleHeroSelectRow = new SingleHeroSelectRow();
                singleHeroSelectRow.setHeroImage(getResources().getIdentifier(DotabuffInfo.rawHeroesString[i].replace("-",""), "drawable", getPackageName()));
                singleHeroSelectRow.setHeroName(DotabuffInfo.niceHeroesString.get(i));
                //надо для всех героев из selectedHeroes найти этого героя
                //если winrate < 0, то INNER имеет преимущество над OUTER
                //если winrate > 0, то OUTER имеет преимущество над INNER
                //мне нужны лучшие герои против выбранных
                //соответственно, мне надо, чтобы disadvntage был наибольшим
                //соответственно, innerHero - тот герой, который в списке выбранных, outerHero - в списке контрпиков.
                //"innerHero":"MEEPO","outerHero":"ELDER_TITAN","percent":13.2402

                singleHeroSelectRow.setWinrate(0.0);
                bestDisadvantages.add(singleHeroSelectRow);
            }

        }
        for(int i = 0; i < selectedHeroes.size(); i++){
            String heroName = selectedHeroes.get(i).getHeroName();
            int endIndex = (DotabuffInfo.heroesCount - 1)*(1 + DotabuffInfo.niceHeroesString.indexOf(selectedHeroes.get(i).getHeroName()));
            int startIndex = endIndex - DotabuffInfo.heroesCount + 1;

            for(int j = startIndex, k = 0; j < endIndex; j++, k++){ //?????????????????????????????????
                HeroDisadvantage heroDisadvantage = dataManager.getHeroDisadvantageList().get(j);
                String outerHero = heroDisadvantage.getOuterHero().getNiceHero();
                if(selectedHeroesNamesSet.contains(outerHero)){
                    k--;
                    continue;
                }

                double disadvantage =  heroDisadvantage.getPercent();
                disadvantage += bestDisadvantages.get(k).getWinrate();
                disadvantage = Math.round(disadvantage * 100.0) / 100.0;

                bestDisadvantages.get(k).setWinrate(disadvantage);
            }
        }
        bestDisadvantages.sort(new Comparator<SingleHeroSelectRow>() {
            @Override
            public int compare(SingleHeroSelectRow t1, SingleHeroSelectRow t2) {
                return t2.getWinrate().compareTo(t1.getWinrate());
            }
        });

        bestCounterpeeksAdapter = new SingleHeroSelectRowAdapter(this, bestDisadvantages);
        bestCounterpeeksView.setAdapter(bestCounterpeeksAdapter);
    }

    private void fillChosenHeroesView(){
        Intent intent = getIntent();
        selectedHeroes = (List<SelectedHeroCell>) intent.getSerializableExtra("Selected");

        chosenHeroesAdapter = new SelectedHeroCellAdapter(this, selectedHeroes);
        chosenHeroesView.setAdapter(chosenHeroesAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.counterpeeks_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.actionSearch);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Поиск...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.backButton) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
//1)в новой activity Надо сделать 2 recycler view вместо картинки персонажа и имени