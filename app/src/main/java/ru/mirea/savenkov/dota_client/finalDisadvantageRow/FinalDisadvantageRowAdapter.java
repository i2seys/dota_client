package ru.mirea.savenkov.dota_client.finalDisadvantageRow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.savenkov.dota_client.R;

public class FinalDisadvantageRowAdapter extends  RecyclerView.Adapter<FinalDisadvantageRowAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<FinalDisadvantageRow> rows;

    public FinalDisadvantageRowAdapter(Context context, List<FinalDisadvantageRow> rows) {
        this.rows = rows;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public FinalDisadvantageRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.final_disadvantage_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FinalDisadvantageRowAdapter.ViewHolder holder, int position) {
        FinalDisadvantageRow row = rows.get(position);
        holder.heroImage.setImageResource(row.getHeroImage());
        Double value = row.getDisadvantage();
        if(value <= 0){
            holder.disadvantageView.setText(String.valueOf(value));
        }
        else{
            holder.disadvantageView.setText("+" + value);
        }


    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView heroImage;
        final TextView disadvantageView;
        ViewHolder(View view){
            super(view);
            heroImage = view.findViewById(R.id.heroImage);
            disadvantageView = view.findViewById(R.id.disadvantageTextView);
        }
    }
}
