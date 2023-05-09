package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Attr;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.attributesRow.AttributeRow;
import ru.mirea.savenkov.dota_client.attributesRow.AttributeRowAdapter;
import ru.mirea.savenkov.dota_client.config.Attributes;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;
import ru.mirea.savenkov.dota_client.spinerAdapter.TeamSpinerAdapter;

public class StatisticAttributesFragment extends Fragment {
    private int pageNumber;
    private final List<HeroEntity> allyHeroes;
    private final List<HeroEntity> enemyHeroes;

    public static StatisticAttributesFragment newInstance(List<HeroEntity> allyHeroes, List<HeroEntity> enemyHeroes) {
        StatisticAttributesFragment fragment = new StatisticAttributesFragment(allyHeroes, enemyHeroes);
        return fragment;
    }

    public StatisticAttributesFragment(List<HeroEntity> allyHeroes, List<HeroEntity> enemyHeroes) {
        this.allyHeroes = allyHeroes;
        this.enemyHeroes = enemyHeroes;
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

        //----------------------------------------------------
        String[] teams = {"Ваша команда", "Вражеская команда"};
        Spinner spinner = result.findViewById(R.id.enemyOrAllyTeamSpinner);
        TeamSpinerAdapter adapter = new TeamSpinerAdapter(inflater.getContext(), R.layout.team_spinner_row, teams);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                List<HeroEntity> heroCells;//хранятся данные об имени героя и его преимуществе.
                switch (item){
                    case "Ваша команда":
                        //то я беру героев из allyteam и анализирую их
                        heroCells = allyHeroes;
                        break;
                    case "Вражеская команда":
                        heroCells = enemyHeroes;
                        break;
                    default:
                        throw new RuntimeException("Can't resolve spinner choice.");
                }
                List<AttributeRow> attribureRows = getAttributeRows(heroCells);

                //double meta = getMeta()
                //максимально метовый пик - пик с 5 самыми метовыми героями (avg ~ 56%)
                //минимально метовый пик - пик с 5 самыми неметовыми героями (avg ~ 45%)

                RecyclerView recyclerView = result.findViewById(R.id.attributesRecyclerView);
                AttributeRowAdapter adapter = new AttributeRowAdapter(inflater.getContext(), attribureRows);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //-----------------------------------------------

        return result;
    }

    private List<AttributeRow> getAttributeRows(List<HeroEntity> heroCells) {
        Attributes totalAttributes = new Attributes(0.0, 0.0,0.0,0.0,0.0,0.0,0.0,0.0);
        for(HeroEntity heroCell: heroCells){
            DotabuffInfo.HEROES heroName = DotabuffInfo.niceToEnumHero.get(heroCell.getHeroName());
            Attributes heroAttribute = DotabuffInfo.heroesAttributes.get(heroName);

            totalAttributes.setCarry(heroAttribute.getCarry() + totalAttributes.getCarry());
            totalAttributes.setSupport(heroAttribute.getSupport() + totalAttributes.getSupport());
            totalAttributes.setBurst(heroAttribute.getBurst() + totalAttributes.getBurst());
            totalAttributes.setControl(heroAttribute.getControl() + totalAttributes.getControl());
            totalAttributes.setEndurance(heroAttribute.getEndurance() + totalAttributes.getEndurance());
            totalAttributes.setEscape(heroAttribute.getEscape() + totalAttributes.getEscape());
            totalAttributes.setPush(heroAttribute.getPush() + totalAttributes.getPush());
            totalAttributes.setInitiation(heroAttribute.getInitiation() + totalAttributes.getInitiation());
        }
        //делаем все значения средними (на одного героя в этом пике приходятся вот такие значения атрибутов
        totalAttributes.setCarry(Math.round(totalAttributes.getCarry() / heroCells.size() * 100) * 1.0);
        totalAttributes.setSupport(Math.round(totalAttributes.getSupport() / heroCells.size() * 100) * 1.0);
        totalAttributes.setBurst(Math.round(totalAttributes.getBurst() / heroCells.size() * 100) * 1.0);
        totalAttributes.setControl(Math.round(totalAttributes.getControl() / heroCells.size() * 100) * 1.0);
        totalAttributes.setEndurance(Math.round(totalAttributes.getEndurance() / heroCells.size() * 100) * 1.0);
        totalAttributes.setEscape(Math.round(totalAttributes.getEscape() / heroCells.size() * 100)  * 1.0);
        totalAttributes.setPush(Math.round(totalAttributes.getPush() / heroCells.size() * 100)  * 1.0);
        totalAttributes.setInitiation(Math.round(totalAttributes.getInitiation() / heroCells.size() * 100) * 1.0);

        List<AttributeRow> attribureRows = new ArrayList<>();
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.CARRY, totalAttributes.getCarry(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.SUPPORT, totalAttributes.getSupport(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.BURST, totalAttributes.getBurst(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.CONTROL, totalAttributes.getControl(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.ENDURANCE, totalAttributes.getEndurance(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.ESCAPE, totalAttributes.getEscape(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.PUSH, totalAttributes.getPush(), 100.0));
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.INITIATION, totalAttributes.getInitiation(), 100.0));

        Double metaValue = getMeta(heroCells);
        attribureRows.add(new AttributeRow(Attributes.ATTRIBUTE.META, metaValue, 100.0));
        return attribureRows;
    }
    private Double getMeta(List<HeroEntity> heroCells){
        //1)вычисление среднего винрейта максимально и минимально метового пика
        List<HeroWinrate> sortedWinrate = DataManager.getHeroWinrateList().stream().sorted(new Comparator<HeroWinrate>() {
            @Override
            public int compare(HeroWinrate o1, HeroWinrate o2) {
                return o1.getWinrate().compareTo(o2.getWinrate());
            }
        }).collect(Collectors.toList());
        int size = DotabuffInfo.heroesCount; //45.36 45.41 ... 58.96 59.11
        double maxWinratesSum = 0.0;
        double minWinratesSum = 0.0;
        for(int i = 0; i < heroCells.size(); i++){
            maxWinratesSum += sortedWinrate.get(size - i - 1).getWinrate();
        }
        for(int i = 0; i < heroCells.size(); i++){
            minWinratesSum += sortedWinrate.get(i).getWinrate();
        }
        double maxWinrateAvg = maxWinratesSum / heroCells.size();
        double minWinrateAvg = minWinratesSum / heroCells.size();
        double avgWinrateAvg = (maxWinrateAvg + minWinrateAvg) / 2;

        //2)вычисление меты нашего пика
        double currentSum = 0.0;
        for(int i = 0; i < heroCells.size(); i++){
            currentSum += DataManager.getHeroWinrateMap().get(heroCells.get(i).getHeroName()).getWinrate();
        }
        double currentAvg = currentSum / heroCells.size();

        //если отрицательный - то отражает диапазон от 0 до 50 (-99 -> 0)
        //если положительный - то отражает диапазон от 50 до 100 (0 -> 99)
        if(currentAvg - avgWinrateAvg < 0){
            double result = ((maxWinrateAvg - minWinrateAvg) * (currentAvg - avgWinrateAvg) + 100.0) / 2.0;
            return Math.floor(result);
        }
        else{
            double result = (maxWinrateAvg - minWinrateAvg) * (currentAvg - avgWinrateAvg) / 2.0 + 50.0;
            return Math.ceil(result);
        }
    }
}