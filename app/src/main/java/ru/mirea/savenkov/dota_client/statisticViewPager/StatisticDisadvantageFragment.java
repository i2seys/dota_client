package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.fragment.app.Fragment;

import ru.mirea.savenkov.dota_client.R;

public class StatisticDisadvantageFragment extends Fragment {
    private int pageNumber;
    private Spinner heroesSpinner;

    public static StatisticDisadvantageFragment newInstance() {
        StatisticDisadvantageFragment fragment = new StatisticDisadvantageFragment();
        return fragment;
    }

    public StatisticDisadvantageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.command_disadvantage_framgent, container, false);
        heroesSpinner = result.findViewById(R.id.heroChooseSpinner);
        return result;
    }

}
