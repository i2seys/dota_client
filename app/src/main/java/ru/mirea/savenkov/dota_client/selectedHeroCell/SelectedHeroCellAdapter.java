package ru.mirea.savenkov.dota_client.selectedHeroCell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.savenkov.dota_client.R;

public class SelectedHeroCellAdapter extends RecyclerView.Adapter<SelectedHeroCellAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<SelectedHeroCell> selectedHeroCells;
    private final OnCellClickListener onCellClickListener;
    public interface OnCellClickListener{
        void onCellClick(SelectedHeroCell heroSelectRow, int position);
    }

    public void addItem(SelectedHeroCell item){
        int index = selectedHeroCells.size();
        selectedHeroCells.add(index, item);
        notifyItemInserted(index);
    }
    public boolean removeItem(SelectedHeroCell item){
        for(int i = 0; i < selectedHeroCells.size(); i++){
            if(selectedHeroCells.get(i).equals(item)){
                selectedHeroCells.remove(i);
                notifyItemRemoved(i);
                return true;
            }
        }
        return false;
    }

    public SelectedHeroCellAdapter(Context context, List<SelectedHeroCell> selectedHeroCells, OnCellClickListener onCellClickListener) {
        this.selectedHeroCells = selectedHeroCells;
        this.onCellClickListener = onCellClickListener;
        this.inflater = LayoutInflater.from(context);
    }

    public SelectedHeroCellAdapter(Context context, List<SelectedHeroCell> selectedHeroCells) {
        this.selectedHeroCells = selectedHeroCells;
        this.inflater = LayoutInflater.from(context);
        this.onCellClickListener = null;
    }

    @Override
    public SelectedHeroCellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cell_single_chosen_hero_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SelectedHeroCellAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SelectedHeroCell selectedHeroCell = selectedHeroCells.get(position);
        holder.heroImage.setImageResource(selectedHeroCell.getHeroImage());
        holder.heroName.setText(selectedHeroCell.getHeroName());

        if(onCellClickListener != null){
            holder.heroImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCellClickListener.onCellClick(selectedHeroCell, position);
                }
            });
        }
        else{
            holder.heroImage.setClickable(false);
        }
    }

    @Override
    public int getItemCount() {
        return selectedHeroCells.size();
    }

    public List<SelectedHeroCell> getSelectedHeroCells() {
        return selectedHeroCells;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView heroImage;
        final TextView heroName;
        ViewHolder(View view){
            super(view);
            heroImage = view.findViewById(R.id.heroImage);
            heroName = view.findViewById(R.id.heroName);
        }
    }
}
