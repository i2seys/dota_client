package ru.mirea.savenkov.dota_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.heroSelectRow.SingleHeroSelectRow;
import ru.mirea.savenkov.dota_client.heroSelectRow.SingleHeroSelectRowAdapter;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCellAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView heroesForChooseView;
    private RecyclerView chosenHeroesView;
    private ArrayList<SingleHeroSelectRow> heroesForChooseRows = new ArrayList<>();
    private SingleHeroSelectRowAdapter heroesForChooseAdapter;
    private ArrayList<SelectedHeroCell> chosenHeroes = new ArrayList<>();
    private SelectedHeroCellAdapter chosenHeroesAdapter;
    public static SearchView searchView;
    private Class fromActivity;
    private Intent oldIntent;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_choose);

        heroesForChooseView = findViewById(R.id.heroesListView);
        chosenHeroesView = findViewById(R.id.chosenHeroesView);

        //5 героев сверху
        fillChosenHeroesRecyclerView();
        //124 героя снизу
        fillHeroesListView();

        //добавить невозможность нажатия на элемент в выборе героев
        // и на кнопку перелистывания дальше

        if(getString(R.string.downloadErrorExtraValue)
                .equals(getIntent().getStringExtra(getString(R.string.downloadSuccessExtra)))){
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.downloadErrorDialogText))
                    .setTitle("Ошибка загрузки данных.")
                    .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hero_choose_menu, menu);

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
                heroesForChooseAdapter.filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.toCounterpicksBtn) {
            if(getString(R.string.downloadErrorExtraValue)
                    .equals(getIntent().getStringExtra(getString(R.string.downloadSuccessExtra)))){
                Toast.makeText(this, getString(R.string.downloadErrorDialogTextShort), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            }
            if(chosenHeroesAdapter.getItemCount() == 0){
                Toast toast = Toast.makeText(this, "Выберите хотя бы одного героя.",Toast.LENGTH_SHORT);
                toast.show();
                return super.onOptionsItemSelected(item);
            }
            Intent intent = new Intent(this, CounterpicksActivity.class);
            //баг какой-то, когда с 2 активити удаляется элемент и вылетает ошибка cant insert item
            //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

            intent.putExtra(getString(R.string.selectedHeroes), (Serializable) chosenHeroesAdapter.getSelectedHeroCells());
            intent.putExtra(getString(R.string.fromClassIntent), getString(R.string.mainActivityName));
//            if(oldIntent != null && oldIntent.hasExtra(getString(R.string.fromClassIntent))
//                    && getString(R.string.counterpicksActivityName)
//                    .equals(oldIntent.getStringExtra(getString(R.string.fromClassIntent)))){
//                intent.putExtra(getString(R.string.counterpeeksRVRemoveData),getString(R.string.No));
//            }
            startActivity(intent);
        }
        else if(id == R.id.actionSettings){
            new Thread(() -> DataManager.secondGetData(MainActivity.this)).start();
        }
        return super.onOptionsItemSelected(item);
    }

    public void fillChosenHeroesRecyclerView(){
        //если не из counterpeeksactivity, то обнуляем
        if(!getString(R.string.counterpicksActivityName)
            .equals(getIntent().getStringExtra(getString(R.string.fromClassIntent)))){
            chosenHeroes = new ArrayList<>();
        }
        SelectedHeroCellAdapter.OnCellClickListener cellClickListener = new SelectedHeroCellAdapter.OnCellClickListener() {
            @Override
            public void onCellClick(SelectedHeroCell selectedHeroCell, int position) {
                HeroWinrate heroWinrate = DataManager.getHeroWinrateMap().get(selectedHeroCell.getHeroName());
                SingleHeroSelectRow heroToSend = new SingleHeroSelectRow(selectedHeroCell.getHeroImage(), heroWinrate.getHero().getNiceHero(), selectedHeroCell.getValue());

                if(chosenHeroesAdapter.removeItem(selectedHeroCell)){
                    heroesForChooseAdapter.addItem(heroToSend, heroesForChooseView);
                }
            }
        };

        chosenHeroesAdapter = new SelectedHeroCellAdapter(this, chosenHeroes, cellClickListener);
        // устанавливаем для списка адаптер
        chosenHeroesView.setAdapter(chosenHeroesAdapter);
        Log.i(TAG,"(My) Chosen heroes recycler view filled.");
    }
    public void fillHeroesListView(){
        if(!getString(R.string.counterpicksActivityName)
                .equals(getIntent().getStringExtra(getString(R.string.fromClassIntent)))){
            heroesForChooseRows = new ArrayList<>();
        }
        for(int i = 0; i < DataManager.getHeroWinrateList().size(); i++){
            int pictureId = getResources().getIdentifier(DotabuffInfo.rawHeroesString[i].replace("-",""), "drawable", getPackageName());
            String heroName = DataManager.getHeroWinrateList().get(i).getHero().getNiceHero();
            double heroWinrate = DataManager.getHeroWinrateList().get(i).getWinrate();

            heroesForChooseRows.add(new SingleHeroSelectRow(pictureId, heroName, heroWinrate));
        }

        SingleHeroSelectRowAdapter.OnRowClickListener rowClickListener = (singleHeroSelectRow, position) -> {
            if(getString(R.string.downloadErrorExtraValue)
                    .equals(MainActivity.this.getIntent().getStringExtra(getString(R.string.downloadSuccessExtra)))){
                Toast.makeText(MainActivity.this, getString(R.string.downloadErrorDialogTextShort), Toast.LENGTH_SHORT).show();
                return;
            }
            if(chosenHeroesAdapter.getItemCount() == 5){
                return;
            }
            SelectedHeroCell heroToSend = new SelectedHeroCell(singleHeroSelectRow.getHeroImage(), singleHeroSelectRow.getHeroName(), singleHeroSelectRow.getValue());

            if(heroesForChooseAdapter.removeItem(singleHeroSelectRow)){
                chosenHeroesAdapter.addItem(heroToSend);
            }

        };
        heroesForChooseAdapter = new SingleHeroSelectRowAdapter
                (this, heroesForChooseRows, rowClickListener);

        heroesForChooseView.setAdapter(heroesForChooseAdapter);
        Log.i(TAG,"(My) Heroes for chose recycler view filled.");
    }
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        oldIntent = getIntent();
        this.setIntent(intent);
        Intent newIntent = getIntent();

        if(getString(R.string.startSplashActivityName)
                .equals(newIntent.getStringExtra(getString(R.string.fromClassIntent)))){
            fromActivity = StartSplashActivity.class;
        }
    }
}
