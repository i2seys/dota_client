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
import ru.mirea.savenkov.dota_client.heroEntity.HeroEntity;

public class SelectedHeroCellAdapter extends RecyclerView.Adapter<SelectedHeroCellAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<HeroEntity> heroEntities;
    private final OnCellClickListener onCellClickListener;
    public interface OnCellClickListener{
        void onCellClick(HeroEntity heroSelectRow, int position);
    }

    public void addItem(HeroEntity item){
        int index = heroEntities.size();
        heroEntities.add(index, item);
        notifyItemInserted(index);
    }
    public boolean removeItem(HeroEntity item){
        for(int i = 0; i < heroEntities.size(); i++){
            if(heroEntities.get(i).equals(item)){
                heroEntities.remove(i);
                notifyItemRemoved(i);
                return true;
            }
        }
        return false;
    }

    public SelectedHeroCellAdapter(Context context, List<HeroEntity> heroEntities, OnCellClickListener onCellClickListener) {
        this.heroEntities = heroEntities;
        this.onCellClickListener = onCellClickListener;
        this.inflater = LayoutInflater.from(context);
    }

    public SelectedHeroCellAdapter(Context context, List<HeroEntity> heroEntities) {
        this.heroEntities = heroEntities;
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
        HeroEntity heroEntity = heroEntities.get(position);
        holder.heroImage.setImageResource(heroEntity.getHeroImage());
        holder.heroName.setText(heroEntity.getHeroName());

        if(onCellClickListener != null){
            holder.heroImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCellClickListener.onCellClick(heroEntity, position);
                }
            });
        }
        else{
            holder.heroImage.setClickable(false);
        }
    }

    @Override
    public int getItemCount() {
        return heroEntities.size();
    }

    public List<HeroEntity> getSelectedHeroCells() {
        return heroEntities;
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
