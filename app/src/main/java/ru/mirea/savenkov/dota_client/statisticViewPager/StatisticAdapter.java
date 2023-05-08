package ru.mirea.savenkov.dota_client.statisticViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;

public class StatisticAdapter extends FragmentStateAdapter {
    private final List<HeroEntity> allyHeroes;
    private final List<HeroEntity> enemyHeroes;
    private final FragmentActivity fragmentActivity;
    public StatisticAdapter(FragmentActivity fragmentActivity, List<HeroEntity>  allyHeroes, List<HeroEntity>  enemyHeroes) {
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
