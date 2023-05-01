package ru.mirea.savenkov.dota_client.attributesRow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Attr;

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
        holder.attributeName.setText(row.getRowName());
        holder.attributeValue.setText(String.format("%s/%s",  Math.round(row.getActualValue()), Math.round(row.getMaxValue())));
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
