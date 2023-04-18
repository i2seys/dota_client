package ru.mirea.savenkov.dota_client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {//ActionBarActivity AppCompatActivity
    private DataManager dataManager = DataManager.getInstance();
    private RecyclerView heroesForChooseView;
    private RecyclerView chosenHeroesView;
    private ArrayList<SingleHeroSelectRow> heroesForChooseRows = new ArrayList<>();
    private SingleHeroSelectRowAdapter heroesForChooseAdapter;
    private ArrayList<SelectedHeroCell> chosenHeroes = new ArrayList<>();
    private SelectedHeroCellAdapter chosenHeroesAdapter;
    public static SearchView searchView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_choose);

        heroesForChooseView = findViewById(R.id.heroesListView);
        chosenHeroesView = findViewById(R.id.chosenHeroesView);
        //chosenHeroesView.setHasFixedSize(true);

        fillChosenHeroesRecycleView();
        fillHeroesListView();
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
            if(chosenHeroesAdapter.getItemCount() == 0){
                Toast toast = Toast.makeText(this, "Выберите хотя бы одного героя.",Toast.LENGTH_SHORT);
                toast.show();
                return super.onOptionsItemSelected(item);
            }
            Intent intent = new Intent(this, CounterpicksActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

            intent.putExtra("Selected", (Serializable) chosenHeroesAdapter.getSelectedHeroCells());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillChosenHeroesRecycleView(){
        SelectedHeroCellAdapter.OnCellClickListener cellClickListener = new SelectedHeroCellAdapter.OnCellClickListener() {
            @Override
            public void onCellClick(SelectedHeroCell selectedHeroCell, int position) {
                HeroWinrate heroWinrate = dataManager.getHeroWinrateMap().get(selectedHeroCell.getHeroName());
                SingleHeroSelectRow heroToSend = new SingleHeroSelectRow(selectedHeroCell.getHeroImage(), heroWinrate.getHero().getNiceHero(), heroWinrate.getWinrate());

                chosenHeroesAdapter.removeItem(selectedHeroCell);
                heroesForChooseAdapter.addItem(heroToSend, heroesForChooseView);
            }
        };
        chosenHeroesAdapter = new SelectedHeroCellAdapter(this, chosenHeroes, cellClickListener);
        // устанавливаем для списка адаптер
        chosenHeroesView.setAdapter(chosenHeroesAdapter);
    }
    private void fillHeroesListView(){
        for(int i = 0; i < dataManager.getHeroWinrateList().size(); i++){
            int pictureId = getResources().getIdentifier(DotabuffInfo.rawHeroesString[i].replace("-",""), "drawable", getPackageName());
            String heroName = dataManager.getHeroWinrateList().get(i).getHero().getNiceHero();
            double heroWinrate = dataManager.getHeroWinrateList().get(i).getWinrate();

            heroesForChooseRows.add(new SingleHeroSelectRow(pictureId, heroName, heroWinrate));
        }

        SingleHeroSelectRowAdapter.OnRowClickListener rowClickListener = (singleHeroSelectRow, position) -> {
            if(chosenHeroesAdapter.getItemCount() == 5){
                return;
            }
            SelectedHeroCell heroToSend = new SelectedHeroCell(singleHeroSelectRow.getHeroImage(), singleHeroSelectRow.getHeroName());

            chosenHeroesAdapter.addItem(heroToSend);
            heroesForChooseAdapter.removeItem(singleHeroSelectRow);
        };
        heroesForChooseAdapter = new SingleHeroSelectRowAdapter
                (this, heroesForChooseRows, rowClickListener);

        heroesForChooseView.setAdapter(heroesForChooseAdapter);

    }
}
//БАГ: быстрое двойное нажатие по иконке героя
//сделать функцоионал кнопки "Загрузить данные"
//сделать красивый вид иконок выбранных героев
//поменять цвета проекта (хочу оранжевый)
//добавить последнее активити для более красивого вывода

//сделать поиск на counterpeeksActivity !!!

//как сделать вывод для двух выбранных ролей? для трёх? для четырёх? для пяти?
//возможно надо будет переопределять адаптер, создавая случаи для 1,2,3,4 и 5 героев(чтобы было видно их имена и картинки)
//плюс к этому создавать 4 новых лейаута по типу HeroSelectRow, например HeroSelectRow2, HeroSelectRow3, ...
//и в адаптере во все методы добавить случаи для 2,3,4 и 5 выбранных героев