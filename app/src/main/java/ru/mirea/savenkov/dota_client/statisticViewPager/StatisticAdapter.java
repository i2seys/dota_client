package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.StatisticActivity;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.statisticSpinerAdapter.StatisticSpinerAdatper;

public class StatisticAdapter extends FragmentStateAdapter {
    private final List<SelectedHeroCell> allyHeroes;
    private final List<SelectedHeroCell> enemyHeroes;
    private final FragmentActivity fragmentActivity;
    public StatisticAdapter(FragmentActivity fragmentActivity, List<SelectedHeroCell>  allyHeroes, List<SelectedHeroCell>  enemyHeroes) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
        this.allyHeroes = allyHeroes;
        this.enemyHeroes = enemyHeroes;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                StatisticDisadvantageFragment statisticDisadvantageFragment = StatisticDisadvantageFragment.newInstance(allyHeroes, enemyHeroes);
                return statisticDisadvantageFragment;
            case 1:
                StatisticAttributesFragment statisticAttributesFragment = StatisticAttributesFragment.newInstance(allyHeroes, enemyHeroes);
                return statisticAttributesFragment;

            default:
                throw new RuntimeException("Wrong position in ViewPager.");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
