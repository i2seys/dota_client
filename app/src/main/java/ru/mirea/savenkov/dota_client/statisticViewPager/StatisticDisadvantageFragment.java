package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.statisticSpinerAdapter.StatisticSpinerAdatper;

public class StatisticDisadvantageFragment extends Fragment {
    private int pageNumber;
    private Spinner heroesSpinner;
    private final List<SelectedHeroCell> allyHeroes;
    private final List<SelectedHeroCell> enemyHeroes;
    private final List<SelectedHeroCell> allHeroes;
    private final int separator;

    public static StatisticDisadvantageFragment newInstance(List<SelectedHeroCell> allyHeroes, List<SelectedHeroCell> enemyHeroes) {
        StatisticDisadvantageFragment fragment = new StatisticDisadvantageFragment(allyHeroes, enemyHeroes);
        return fragment;
    }

    public StatisticDisadvantageFragment(List<SelectedHeroCell> allyHeroes, List<SelectedHeroCell> enemyHeroes) {
        this.allyHeroes = allyHeroes;
        this.enemyHeroes = enemyHeroes;

        this.allHeroes = new ArrayList<>();
        this.allHeroes.addAll(allyHeroes);
        this.allHeroes.addAll(enemyHeroes);

        this.separator = allyHeroes.size();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.command_disadvantage_framgent, container, false);
        heroesSpinner = result.findViewById(R.id.heroChooseSpinner);

        StatisticSpinerAdatper adatper = new StatisticSpinerAdatper(inflater.getContext(), R.layout.spinner_row_layout, allHeroes, allyHeroes.size());
        heroesSpinner.setAdapter(adatper);

        heroesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(), allHeroes.get(pos).getHeroName().toString() + (pos < separator ? ": Союз." : ": Враг"), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });

        return result;
    }

    public Spinner getHeroesSpinner() {
        return heroesSpinner;
    }
}
