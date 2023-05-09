package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCellAdapter;
import ru.mirea.savenkov.dota_client.statisticViewPager.StatisticAdapter;

public class StatisticActivity extends AppCompatActivity{
    private RecyclerView enemyHeroesView;
    private RecyclerView allyHeroesView;
    private SelectedHeroCellAdapter enemyHeroesAdapter;
    private SelectedHeroCellAdapter allyHeroesAdapter;
    private TextView totalAdvantage;
    private List<HeroEntity> allyHeroesList;
    private List<HeroEntity> enemyHeroesList;
    private ViewPager2 statisticViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        LinearLayout allyEnemyLayout = findViewById(R.id.allyEnemyLayout);
        statisticViewPager = findViewById(R.id.statisticPager);
        enemyHeroesView = allyEnemyLayout.findViewById(R.id.enemyHeroesView).findViewById(R.id.chosenHeroesView);
        allyHeroesView = allyEnemyLayout.findViewById(R.id.allyHeroesView).findViewById(R.id.chosenHeroesView);
        totalAdvantage = allyEnemyLayout.findViewById(R.id.totalAdvantageTextView);

        fillEnemyHeroesView();
        fillAllyHeroesView();
        fillAdvantageTextView();
        fillViewPager();
        fillLabels();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillEnemyHeroesView();
        fillAllyHeroesView();
        fillAdvantageTextView();
        fillViewPager();
        fillLabels();
    }

    private void fillLabels() {
        TextView allyTextView = findViewById(R.id.yourHeroesTV);
        TextView enemyTextView = findViewById(R.id.enemyHeroesTV);
        Drawable picEnemy = ResourcesCompat.getDrawable(getResources(), R.drawable.red_circle, getTheme());
        Drawable picAlly = ResourcesCompat.getDrawable(getResources(), R.drawable.green_circle, getTheme());
        picEnemy.setBounds(-5,0,35,40);
        picAlly.setBounds(-5,0,35,40);
        allyTextView.setCompoundDrawables(picAlly, null, null, null);
        enemyTextView.setCompoundDrawables(picEnemy, null, null, null);
    }

    private void fillViewPager() {
        FragmentStateAdapter pageAdapter = new StatisticAdapter(this, allyHeroesList, enemyHeroesList);
        statisticViewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, statisticViewPager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Преимущество");
                        break;
                    case 1:
                        tab.setText("Атрибуты");
                        break;
                    default:
                        throw new RuntimeException("Wrong TabLayout index.");
                }
            }
        });
        tabLayoutMediator.attach();
    }

    private void fillAdvantageTextView() {
        double advantage = getIntent().getDoubleExtra("Advantage", Double.MAX_VALUE);
        if(advantage == Double.MAX_VALUE){
            throw new RuntimeException("Wrong advantage.");
        }
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

    private void fillAllyHeroesView() {
        allyHeroesList = (List<HeroEntity>)getIntent().getSerializableExtra(getString(R.string.selectedAllyHeroes));
        allyHeroesAdapter = new SelectedHeroCellAdapter(this, allyHeroesList);
        allyHeroesView.setAdapter(allyHeroesAdapter);
    }

    private void fillEnemyHeroesView() {
        enemyHeroesList = (List<HeroEntity>)getIntent().getSerializableExtra(getString(R.string.selectedEnemyHeroes));
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
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        //Intent oldIntent = getIntent();
        this.setIntent(intent);
        //Intent newIntent = getIntent();
    }
}
