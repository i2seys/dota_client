package ru.mirea.savenkov.dota_client.statisticSpinerAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;

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
        Context ctx = inflater.getContext();
        View row = inflater.inflate(R.layout.spinner_row_layout, parent, false);
        TextView heroName = row.findViewById(R.id.heroName);
        ImageView heroImage = row.findViewById(R.id.heroIcon);

        heroName.setText(allHeroes.get(position).getHeroName());
        heroImage.setImageResource(allHeroes.get(position).getHeroImage());
        Drawable pic;
        if(position < separator){
            pic = AppCompatResources.getDrawable(ctx, R.drawable.green_circle);
        }
        else{
            pic = AppCompatResources.getDrawable(ctx, R.drawable.red_circle);
        }
        pic.setBounds(0,0,25,25);
        heroName.setCompoundDrawables(pic, null, null,null);
        return row;
    }
}
