package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;
import java.util.Scanner;

import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.statisticSpinerAdapter.StatisticSpinerAdatper;

public class StatisticAdapter extends FragmentStateAdapter {
    private Spinner heroesSpinnerDisadvantage;
    private StatisticDisadvantageFragment statisticDisadvantageFragment;
    public StatisticAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return StatisticDisadvantageFragment.newInstance();
            case 1:
                return StatisticAttributesFragment.newInstance();
            default:
                throw new RuntimeException("Wrong position in ViewPager.");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
