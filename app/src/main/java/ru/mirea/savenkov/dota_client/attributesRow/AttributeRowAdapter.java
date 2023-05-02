package ru.mirea.savenkov.dota_client.attributesRow;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.config.Attributes;

public class AttributeRowAdapter extends RecyclerView.Adapter<AttributeRowAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<AttributeRow> rows;

    public AttributeRowAdapter(Context context, List<AttributeRow> rows) {
        this.rows = rows;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AttributeRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.attribute_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttributeRowAdapter.ViewHolder holder, int position) {
        AttributeRow row = rows.get(position);
        Attributes.ATTRIBUTE attr = row.getAttributeName();
        holder.attributeName.setText(String.format("%s: ", attr.getNiceHero()));
        long actualValue = Math.round(row.getActualValue());
        long maxValue = Math.round(row.getMaxValue());
        holder.attributeValue.setText(String.format("%s/%s",  actualValue, maxValue));

        Resources r = inflater.getContext().getResources();
        Resources.Theme t = inflater.getContext().getTheme();
        switch (attr){
            case CARRY:
                if(actualValue >= 27 && actualValue < 47){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                break;
            case SUPPORT:
                if(actualValue >= 20 && actualValue < 40){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                break;
            case BURST:
                if (actualValue < 20){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 40){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
            case CONTROL:
                if (actualValue < 27){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 47){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
            case ENDURANCE:
                if (actualValue < 14){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 33){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
            case ESCAPE:
                if (actualValue < 14){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 33){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
            case PUSH:
                if (actualValue < 14){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 21){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
            case INITIATION:
                if (actualValue < 21){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.red, t));
                }
                else if(actualValue < 33){
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.orange, t));
                }
                else{
                    holder.attributeName.setBackgroundColor(r.getColor(R.color.green, t));
                }
                break;
        }
        //быстрый урон: < 20 - плохо, >=20 и <40 - средне, >= 40 - отлично
        //контроль: < 27 -плохо, >= 27 и < 47 - средне, >= 47 - отлично
        //стойкость:< 14 - плохо, >= 14 и < 33 - средне, >= 33 - отлично
        //побег: < 14 - плохо, >= 14 и < 33 - средне, >= 33 - отлично
        //осада: < 14 - плохо, >= 14 и < 21 - средне, >= 21 - отлично
        //инициация: < 21 - плохо, >= 21 и < 33 - средне, >= 33 - отлично
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView attributeName, attributeValue;
        ViewHolder(View view){
            super(view);
            attributeName = view.findViewById(R.id.attributeName);
            attributeValue = view.findViewById(R.id.attributeValue);
        }
    }
}
