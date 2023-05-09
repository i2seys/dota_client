package ru.mirea.savenkov.dota_client.attributesRow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
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
        Context ctx = inflater.getContext();
        AttributeRow row = rows.get(position);
        Attributes.ATTRIBUTE attr = row.getAttributeName();
        holder.attributeName.setText(String.format("%s: ", attr.getNiceHero()));
        long actualValue = Math.round(row.getActualValue());
        long maxValue = Math.round(row.getMaxValue());
        holder.attributeValue.setText(String.format("%s/%s",  actualValue, maxValue));

        Resources r = ctx.getResources();
        Resources.Theme t = ctx.getTheme();
        Drawable pic = null;
        Drawable greenArrow = ResourcesCompat.getDrawable(r, R.drawable.green_triangle, t);
        Drawable redArrow = ResourcesCompat.getDrawable(r, R.drawable.red_triangle, t);
        Drawable orangeSquare = ResourcesCompat.getDrawable(r, R.drawable.orange_square, t);
        switch (attr){
            case CARRY:
                if(actualValue >= 27 && actualValue < 47){
                    pic = greenArrow;
                }
                else{
                    pic = redArrow;
                }
                break;
            case SUPPORT:
                if(actualValue >= 20 && actualValue < 40){
                    pic = greenArrow;
                }
                else{
                    pic = redArrow;
                }
                break;
            case BURST:
                if (actualValue < 20){
                    pic = redArrow;
                }
                else if(actualValue < 40){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
            case CONTROL:
                if (actualValue < 27){
                    pic = redArrow;
                }
                else if(actualValue < 47){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
            case ENDURANCE:
                if (actualValue < 14){
                    pic = redArrow;
                }
                else if(actualValue < 33){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
            case ESCAPE:
                if (actualValue < 14){
                    pic = redArrow;
                }
                else if(actualValue < 33){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
            case PUSH:
                if (actualValue < 14){
                    pic = redArrow;
                }
                else if(actualValue < 21){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
            case INITIATION:
                if (actualValue < 21){
                    pic = redArrow;
                }
                else if(actualValue < 33){
                    pic = orangeSquare;
                }
                else{
                    pic = greenArrow;
                }
                break;
        }
        if(pic.equals(greenArrow)){
            pic.setBounds(0,0,50,50);
        }
        else if(pic.equals(redArrow)){
            pic.setBounds(0,0,50,50);
        }
        else if(pic.equals(orangeSquare)){
            pic.setBounds(5,5,45,45);
        }
        holder.attributeValue.setCompoundDrawables(pic, null, null, null);
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
