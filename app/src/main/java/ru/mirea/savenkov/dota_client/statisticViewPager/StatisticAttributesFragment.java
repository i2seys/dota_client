package ru.mirea.savenkov.dota_client.statisticViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.attributesRow.AttributeRow;
import ru.mirea.savenkov.dota_client.attributesRow.AttributeRowAdapter;
import ru.mirea.savenkov.dota_client.config.Attributes;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;

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

        Spinner spinner = result.findViewById(R.id.enemyOrAllyTeamSpinner);
        String[] allyOrEnemyTeam = {"Ваша команда", "Вражеская команда"};
        ArrayAdapter<String> adapter = new ArrayAdapter(inflater.getContext(), android.R.layout.simple_spinner_item, allyOrEnemyTeam);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                List<HeroEntity> heroCells;
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

                RecyclerView recyclerView = result.findViewById(R.id.attributesRecyclerView);
                AttributeRowAdapter adapter = new AttributeRowAdapter(inflater.getContext(), attribureRows);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


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
        return attribureRows;
    }
}