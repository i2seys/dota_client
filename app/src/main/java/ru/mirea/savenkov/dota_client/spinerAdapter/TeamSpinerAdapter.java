package ru.mirea.savenkov.dota_client.spinerAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import ru.mirea.savenkov.dota_client.R;

public class TeamSpinerAdapter extends ArrayAdapter<String> {
    private final LayoutInflater inflater;
    private final String[] teams;

    public TeamSpinerAdapter(Context context, int rowResourceId, String[] teams) {
        super(context, rowResourceId, teams);
        this.inflater = LayoutInflater.from(context);
        this.teams = teams;
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
        View row = inflater.inflate(R.layout.team_spinner_row, parent, false);
        TextView teamName = (TextView)row;

        teamName.setText(teams[position]);
        Drawable pic;
        if(position == 0){
            pic = ResourcesCompat.getDrawable(ctx.getResources(), R.drawable.green_circle, ctx.getTheme());
        }
        else{
            pic = ResourcesCompat.getDrawable(ctx.getResources(), R.drawable.red_circle, ctx.getTheme());
        }
        pic.setBounds(0,0,40,40);
        teamName.setCompoundDrawables(null, null, pic, null);

        return row;
    }
}
