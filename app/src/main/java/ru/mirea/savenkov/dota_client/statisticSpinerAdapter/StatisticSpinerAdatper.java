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
import ru.mirea.savenkov.dota_client.selectedHeroCell.SelectedHeroCell;

public class StatisticSpinerAdatper extends ArrayAdapter<SelectedHeroCell> {
    private final List<SelectedHeroCell> heroesList;
    private final LayoutInflater inflater;

    public StatisticSpinerAdatper(Context context, int textViewResourceId, List<SelectedHeroCell> objects) {
        super(context, textViewResourceId, objects);
        inflater = LayoutInflater.from(context);
        heroesList = objects;
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

        heroName.setText(heroesList.get(position).getHeroName());
        heroImage.setImageResource(heroesList.get(position).getHeroImage());
        return row;
    }
}
