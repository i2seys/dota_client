package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.finalDisadvantageRow.FinalDisadvantageRow;
import ru.mirea.savenkov.dota_client.finalDisadvantageRow.FinalDisadvantageRowAdapter;
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;
import ru.mirea.savenkov.dota_client.statisticSpinerAdapter.StatisticSpinerAdatper;

public class StatisticDisadvantageFragment extends Fragment {
    private int pageNumber;
    private Spinner heroesSpinner;
    private final List<SelectedHeroCell> allyHeroes;
    private final List<SelectedHeroCell> enemyHeroes;
    private final List<SelectedHeroCell> allHeroes;
    private final int separator;
    private RecyclerView comprasionHeroesRecyclerVew;
    private FinalDisadvantageRowAdapter finalDisadvantageRowAdapter;
    private TextView summaryDisadvantageTextView;
    private ImageButton infoButton;

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

        //РЕСАЙКЛЕР ВЬЮ
        comprasionHeroesRecyclerVew = result.findViewById(R.id.comparsionHeroesRecyclerView);
        summaryDisadvantageTextView = result.findViewById(R.id.summaryAdvantageTextView);
        infoButton = result.findViewById(R.id.infoButton);
        //List<FinalDisadvantageRow> comprasionRows = fromCellsToRows(allyHeroes);
        //finalDisadvantageRowAdapter = new FinalDisadvantageRowAdapter(inflater.getContext(), comprasionRows);
        //comprasionHeroesRecyclerVew.setAdapter(finalDisadvantageRowAdapter);

        StatisticSpinerAdatper statisticSpinnerAdadpter = new StatisticSpinerAdatper(inflater.getContext(), R.layout.spinner_row_layout, allHeroes, separator);
        heroesSpinner.setAdapter(statisticSpinnerAdadpter);

        heroesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                List<FinalDisadvantageRow> comprasionRows;
                if(separator <= pos){
                    comprasionRows = fromCellsToRows(allHeroes.get(pos), allyHeroes);
                }
                else{
                    comprasionRows = fromCellsToRows(allHeroes.get(pos), enemyHeroes);
                }
                finalDisadvantageRowAdapter = new FinalDisadvantageRowAdapter(inflater.getContext(), comprasionRows);
                comprasionHeroesRecyclerVew.setAdapter(finalDisadvantageRowAdapter);

                Double totalAdvantage = 0.0;
                for(FinalDisadvantageRow finalDisadvantageRow: comprasionRows){
                    totalAdvantage += finalDisadvantageRow.getDisadvantage();
                }
                totalAdvantage = Math.round(totalAdvantage * 100) / 100.0;
                summaryDisadvantageTextView.setText(String.format("Общее преимущество: %s", totalAdvantage));
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(inflater.getContext())
                        .setMessage(R.string.infoDisadvantageText)
                        .setTitle("Информация о преимуществе.")
                        .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
            }
        });

        return result;
    }

    public Spinner getHeroesSpinner() {
        return heroesSpinner;
    }
    private List<FinalDisadvantageRow> fromCellsToRows(SelectedHeroCell comparsionHero, List<SelectedHeroCell> cells){
        List<FinalDisadvantageRow> result = new ArrayList<>();
        for(int i = 0; i < cells.size(); i++){
            //
            Double value = getHeroesDisadvantage(comparsionHero.getHeroName(), cells.get(i).getHeroName());
            result.add(new FinalDisadvantageRow(cells.get(i).getHeroImage(), value));
        }
        return result;
    }

    private Double getHeroesDisadvantage(String heroName1, String heroName2) {
        DotabuffInfo.HEROES HERO1 = DotabuffInfo.niceToEnumHero.get(heroName1);
        DotabuffInfo.HEROES HERO2 = DotabuffInfo.niceToEnumHero.get(heroName2);
        //(len(heroes) - 1) * (heroes.index(outer_hero) + 1)9
        //тут надо найти их разницу. ?????????????
        int index = (HERO2.ordinal()) * (DotabuffInfo.heroesCount - 1) + HERO1.ordinal();
        if(HERO1.ordinal() > HERO2.ordinal()){
            index--;
        }//
        HeroDisadvantage heroDisadvantage = DataManager.getHeroDisadvantageList().get(index);
        return Math.round(heroDisadvantage.getPercent() * 100) / 100.0;
    }
}


//может вместо того, чтобы менять адаптер, можно поменять список элементов?