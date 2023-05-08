package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.heroSelectRow.SingleHeroSelectRowAdapter;
import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCellAdapter;

public class CounterpicksActivity extends AppCompatActivity {
    private RecyclerView enemyHeroesView;
    private RecyclerView allyHeroesView;
    private RecyclerView bestCounterpeeksView;
    private SelectedHeroCellAdapter enemyHeroesAdapter;
    private SelectedHeroCellAdapter allyHeroesAdapter;
    private SingleHeroSelectRowAdapter bestCounterpeeksAdapter;
    public static SearchView searchView;
    private List<HeroEntity> enemyHeroes;
    private List<HeroEntity> allyHeroes;
    private TextView totalAdvantage;
    private boolean isSelectedChanged = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counterpicks);

        totalAdvantage = findViewById(R.id.totalAdvantageTextView);
        enemyHeroesView = findViewById(R.id.allyEnemyLayout).findViewById(R.id.enemyHeroesView).findViewById(R.id.chosenHeroesView);
        allyHeroesView = findViewById(R.id.allyEnemyLayout).findViewById(R.id.allyHeroesView).findViewById(R.id.chosenHeroesView);
        bestCounterpeeksView = findViewById(R.id.counterpeeksView);

        TextView allyTextView = findViewById(R.id.yourHeroesTV);
        TextView enemyTextView = findViewById(R.id.enemyHeroesTV);
        Drawable picEnemy = ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, getTheme());
        Drawable picAlly = ResourcesCompat.getDrawable(getResources(), R.drawable.green_circle, getTheme());
        picEnemy.setBounds(-5,0,35,40);
        picAlly.setBounds(-5,0,35,40);
        allyTextView.setCompoundDrawables(picAlly, null, null, null);
        enemyTextView.setCompoundDrawables(picEnemy, null, null, null);
    }
    //первый переход с 1 на 2: onStart, onResume
    //переход с 2 на 1: onPause
    //Последующие переходы: onRestart, onStart, onNewIntent onResume

    @Override
    protected void onResume() {
        super.onResume();
        String from = getIntent().getStringExtra(getString(R.string.fromClassIntent));

        if(from.equals(getResources().getString(R.string.mainActivityName))) {
            if(isSelectedChanged){
                fillEnemyHeroesView();
                fillAllyHeroesView();
                fillBestCounterpeeksView();
                updateTotalAdvantage(0.0);
            }
        }
    }


    private void fillAllyHeroesView() {
        allyHeroes = new ArrayList<>();
        SelectedHeroCellAdapter.OnCellClickListener cellClickListener = new SelectedHeroCellAdapter.OnCellClickListener() {
            @Override
            public void onCellClick(HeroEntity selectedHeroCell, int position) {
                HeroWinrate heroWinrate = DataManager.getHeroWinrateMap().get(selectedHeroCell.getHeroName());

                if(!allyHeroesAdapter.removeItem(selectedHeroCell)){
                    return;
                }
                bestCounterpeeksAdapter.addItem(selectedHeroCell, bestCounterpeeksView);
                Double currentAdvantage = Double.parseDouble(totalAdvantage.getText().toString());
                currentAdvantage = currentAdvantage - selectedHeroCell.getValue();
                currentAdvantage = Math.round(currentAdvantage * 100) / 100.0;
                updateTotalAdvantage(currentAdvantage);
            }
        };
        allyHeroesAdapter = new SelectedHeroCellAdapter(this, allyHeroes, cellClickListener);
        allyHeroesView.setAdapter(allyHeroesAdapter);
    }

    private void fillBestCounterpeeksView() {
        //1)получить список наилучших контрпиков
        //2)создать адаптер
        //3)разместить их в view
        Set<String> selectedHeroesNamesSet = new HashSet<>();
        for(int i = 0; i < enemyHeroes.size(); i++){
            selectedHeroesNamesSet.add(enemyHeroes.get(i).getHeroName());
        }
        //0)создаём пустой список с героями (124 - n, где n - кол-во выбранных героев)
        List<HeroEntity> bestDisadvantages = new ArrayList<>(DotabuffInfo.heroesCount - enemyHeroes.size());
        //1)заполняем этот список именами героев и пустым винрейтом
        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            if(!selectedHeroesNamesSet.contains(DotabuffInfo.niceHeroesString.get(i))){
                HeroEntity singleHeroSelectRow = new HeroEntity();
                singleHeroSelectRow.setHeroImage(getResources().getIdentifier(DotabuffInfo.rawHeroesString[i].replace("-",""), "drawable", getPackageName()));
                singleHeroSelectRow.setHeroName(DotabuffInfo.niceHeroesString.get(i));
                //надо для всех героев из selectedHeroes найти этого героя
                //если winrate < 0, то INNER имеет преимущество над OUTER
                //если winrate > 0, то OUTER имеет преимущество над INNER
                //мне нужны лучшие герои против выбранных
                //соответственно, мне надо, чтобы disadvntage был наибольшим
                //соответственно, innerHero - тот герой, который в списке выбранных, outerHero - в списке контрпиков.
                //"innerHero":"MEEPO","outerHero":"ELDER_TITAN","percent":13.2402

                singleHeroSelectRow.setValue(0.0);
                bestDisadvantages.add(singleHeroSelectRow);
            }
        }
        //2)считаем винрейт
        for(int i = 0; i < enemyHeroes.size(); i++){
            String outerHero = enemyHeroes.get(i).getHeroName();
            //String innerHero = enemyHeroes.get(i).getHeroName();
            int endIndex = (DotabuffInfo.heroesCount - 1)*(1 + DotabuffInfo.niceHeroesString.indexOf(enemyHeroes.get(i).getHeroName()));
            int startIndex = endIndex - DotabuffInfo.heroesCount + 1;

            for(int j = startIndex, k = 0; j < endIndex; j++, k++){ //?????????????????????????????????
                HeroDisadvantage heroDisadvantage = DataManager.getHeroDisadvantageList().get(j);
                String innerHero = heroDisadvantage.getInnerHero().getNiceHero();
                //String outerHero = heroDisadvantage.getOuterHero().getNiceHero();
                //if(selectedHeroesNamesSet.contains(outerHero)){
                //if(outerHero.equals(innerHero)){
                if(selectedHeroesNamesSet.contains(innerHero)){
                    k--;
                    continue;
                }

                double disadvantage =  heroDisadvantage.getPercent();
                disadvantage += bestDisadvantages.get(k).getValue();
                disadvantage = Math.round(disadvantage * 100.0) / 100.0;

                bestDisadvantages.get(k).setValue(disadvantage);
            }
        }
        //3)сортируем по возрастанию
        bestDisadvantages.sort(new Comparator<HeroEntity>() {
            @Override
            public int compare(HeroEntity t1, HeroEntity t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });

        SingleHeroSelectRowAdapter.OnRowClickListener rowClickListener = (singleHeroSelectRow, position) -> {
            if(allyHeroesAdapter.getItemCount() == 5){
                return;
            }
            HeroEntity heroToSend = new HeroEntity(singleHeroSelectRow.getHeroImage(), singleHeroSelectRow.getHeroName(), singleHeroSelectRow.getValue());

            if(!bestCounterpeeksAdapter.removeItem(singleHeroSelectRow)){
                return;
            }
            allyHeroesAdapter.addItem(heroToSend);
            Double currentAdvantage = Double.parseDouble(totalAdvantage.getText().toString());
            currentAdvantage = currentAdvantage + heroToSend.getValue();
            currentAdvantage = Math.round(currentAdvantage * 100) / 100.0;

            updateTotalAdvantage(currentAdvantage);
        };

        bestCounterpeeksAdapter = new SingleHeroSelectRowAdapter(this, bestDisadvantages, rowClickListener);
        bestCounterpeeksView.setAdapter(bestCounterpeeksAdapter);
    }

    private void fillEnemyHeroesView(){
        Intent intent = getIntent();
        enemyHeroes = (List<HeroEntity>) intent.getSerializableExtra("Selected");

        enemyHeroesAdapter = new SelectedHeroCellAdapter(this, enemyHeroes);
        enemyHeroesView.setAdapter(enemyHeroesAdapter);
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
                bestCounterpeeksAdapter.filter(s);
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
            intent.putExtra(getString(R.string.fromClassIntent), getString(R.string.counterpicksActivityName));
            startActivity(intent);
        }
        else if(id == R.id.statisticButton){
            if(allyHeroes.size() == 0){
                Toast.makeText(this, "Выберите хотя бы одного героя вашей команды.", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(this, StatisticActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                intent.putExtra(getString(R.string.selectedAllyHeroes), (Serializable) allyHeroesAdapter.getSelectedHeroCells());
                intent.putExtra(getString(R.string.selectedEnemyHeroes), (Serializable) enemyHeroesAdapter.getSelectedHeroCells());
                intent.putExtra(getString(R.string.selectedAdvantage), Double.parseDouble(totalAdvantage.getText().toString()));

                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        Intent oldIntent = getIntent();
        this.setIntent(intent);
        Intent newIntent = getIntent();
        if(newIntent.getStringExtra(getResources().getString(R.string.fromClassIntent))
                .equals(getString(R.string.statisticActivityName))){
            isSelectedChanged = false;
        }
        else { //значит интент из MainActivity
            isSelectedChanged =  newIntent.getBooleanExtra(getString(R.string.isDataChangedBoolExtra), true);
        }
    }
    private void updateTotalAdvantage(Double advantage){
        totalAdvantage.setText(String.valueOf(advantage));
        Drawable pic;
        if(advantage > 5.0) {
            pic = ResourcesCompat.getDrawable(
                    getResources(), R.drawable.green_triangle, getTheme());
            pic.setBounds(0,0,50,50);
        }
        else if(advantage < -5.0){
            pic = ResourcesCompat.getDrawable(
                    getResources(), R.drawable.red_triangle, getTheme());
            pic.setBounds(0,0,50,50);
        }
        else{
            pic = ResourcesCompat.getDrawable(
                    getResources(), R.drawable.orange_square, getTheme());
            pic.setBounds(10,0,40,30);
        }
        totalAdvantage.setCompoundDrawables(pic, null, null, null);
    }
}
//я нажимаю на героя, он перемещается во внутренний контейнер (yourTeamHeroes).
//в этом контейнере будут храниться герои вашей команды.
//по мере добавления героев будет отображаться общее преимущество над командой врага.
//также по мере добавления будет отображаться, каких параметров команде не хватает

//параметры: лейт, пуш, ёрли гейм, магический урон, физический урон, инициация, дизейбл, танк, керри, саппорт, нюкер

//в меню надо добавить выпадающий список, который будет использоваться для выбора героев
// и их переноса в список героев нашей команды.

//можно добавить кнопку "сводка по вашим героям", в которой будет
//-параметры(те, которых много - )
//-общее преимущество
//-преимущество каждого героя над каждым
//-возможно, вероятность победы - ???
//-как хороши герои в данной мете(процент побед)

//частично данные можно взять с сайта доты https://www.dota2.com/hero/abaddon