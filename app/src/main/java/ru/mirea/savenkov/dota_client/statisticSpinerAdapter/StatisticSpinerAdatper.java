package ru.mirea.savenkov.dota_client.statisticSpinerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;

public class StatisticSpinerAdatper extends ArrayAdapter<HeroEntity> {
    private final List<HeroEntity> allHeroes;
    private final LayoutInflater inflater;
    private final int separator;
    public StatisticSpinerAdatper(Context context, int rowResourceId, List<HeroEntity> objects, int separator) {
        super(context, rowResourceId, objects);
        this.inflater = LayoutInflater.from(context);
        this.allHeroes = objects;
        this.separator = separator;
    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.spinner_row_layout, parent, false);
        TextView heroName = row.findViewById(R.id.heroName);
        ImageView heroImage = row.findViewById(R.id.heroIcon);

        heroName.setText(allHeroes.get(position).getHeroName());
        heroImage.setImageResource(allHeroes.get(position).getHeroImage());
        if(position < separator){
            heroName.setBackgroundColor(inflater.getContext().getColor(R.color.green));
            //row.setBackgroundColor(inflater.getContext().getColor(R.color.green));
        }
        else{
            heroName.setBackgroundColor(inflater.getContext().getColor(R.color.red));
            //row.setBackgroundColor(inflater.getContext().getColor(R.color.red));
        }
        return row;
    }
}
