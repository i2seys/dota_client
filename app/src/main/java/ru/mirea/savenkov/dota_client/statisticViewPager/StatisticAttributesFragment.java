package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ru.mirea.savenkov.dota_client.R;

public class StatisticAttributesFragment extends Fragment {
    private int pageNumber;

    public static StatisticAttributesFragment newInstance() {
        StatisticAttributesFragment fragment = new StatisticAttributesFragment();
        return fragment;
    }

    public StatisticAttributesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.command_attributes_fragment, container, false);

        return result;
    }
}
