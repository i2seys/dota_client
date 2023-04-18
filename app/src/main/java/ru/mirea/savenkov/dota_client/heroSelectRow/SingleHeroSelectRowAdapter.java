package ru.mirea.savenkov.dota_client.heroSelectRow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.savenkov.dota_client.MainActivity;
import ru.mirea.savenkov.dota_client.R;

public class SingleHeroSelectRowAdapter extends  RecyclerView.Adapter<SingleHeroSelectRowAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<SingleHeroSelectRow> singleHeroSelectRows;
    private final OnRowClickListener onRowClickListener;
    private final List<SingleHeroSelectRow> initialItems;

    public interface OnRowClickListener{
        void onRowClick(SingleHeroSelectRow singleHeroSelectRow, int position);
    }
    public void addItem(SingleHeroSelectRow item, RecyclerView heroToChooseView){
        String searchText = MainActivity.searchView.getQuery().toString();

        if(searchText.isEmpty() || item.getHeroName().toLowerCase().contains(searchText.toLowerCase())) {
            if (singleHeroSelectRows.size() == 0) {
                //если стоит фильтр, который убирает вообще все данные (фильтр abaddon, но abaddon уже выбран)

                singleHeroSelectRows.add(0, item);
                notifyItemInserted(0);
            } else {
                int heroSelectRowsIndex = -1;
                if (item.getHeroName().compareTo(singleHeroSelectRows.get(0).getHeroName()) < 0) {
                    heroSelectRowsIndex = 0;
                } else if (item.getHeroName().compareTo(singleHeroSelectRows.get(singleHeroSelectRows.size() - 1).getHeroName()) > 0) {
                    heroSelectRowsIndex = singleHeroSelectRows.size();
                } else {
                    for (int i = 0; i < singleHeroSelectRows.size() - 1; i++) {
                        if (item.getHeroName().compareTo(singleHeroSelectRows.get(i).getHeroName()) > 0 &&
                                item.getHeroName().compareTo(singleHeroSelectRows.get(i + 1).getHeroName()) < 0) {
                            heroSelectRowsIndex = i + 1;
                            break;
                        }
                    }
                    if (heroSelectRowsIndex == -1) {
                        throw new RuntimeException("Can't insert item.");
                    }
                }
                singleHeroSelectRows.add(heroSelectRowsIndex, item);
                notifyItemInserted(heroSelectRowsIndex);
            }
        }

        int initialIndex = -1;
        if(item.getHeroName().compareTo(initialItems.get(0).getHeroName()) < 0){
            initialIndex = 0;
        }
        else if (item.getHeroName().compareTo(initialItems.get(initialItems.size()-1).getHeroName()) > 0){
            initialIndex = initialItems.size();
        }
        else{
            for(int i = 0; i < initialItems.size()-1; i++){
                if(item.getHeroName().compareTo(initialItems.get(i).getHeroName()) > 0 &&
                        item.getHeroName().compareTo(initialItems.get(i+1).getHeroName()) < 0){
                    initialIndex = i + 1;
                    break;
                }
            }
        }
        if(initialIndex == -1){
            throw new RuntimeException("Can't insert item.");
        }

        initialItems.add(initialIndex, item);
    }
    public void removeItem(SingleHeroSelectRow item){
        boolean rowsDeleted = false;
        for(int i = 0; i < singleHeroSelectRows.size(); i++){
            if(item.equals(singleHeroSelectRows.get(i))){
                singleHeroSelectRows.remove(i);
                notifyItemRemoved(i);
                rowsDeleted = true;
                break;
            }
        }
        if(!rowsDeleted){
            throw new RuntimeException("Item does not exits.");
        }
        boolean initialDeleted = false;
        for(int i = 0; i < initialItems.size(); i++){
            if(item.equals(initialItems.get(i))){
                initialItems.remove(i);
                initialDeleted = true;
            }
        }
        if(!initialDeleted){
            throw new RuntimeException("Item does not exits.");
        }
    }
    public void filter(String text) {
        singleHeroSelectRows.clear();
        if(text.isEmpty()){
            singleHeroSelectRows.addAll(initialItems);
        } else{
            text = text.toLowerCase();
            for(SingleHeroSelectRow item: initialItems){
                if(item.getHeroName().toLowerCase().contains(text)){
                    singleHeroSelectRows.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
    public SingleHeroSelectRowAdapter(Context context, List<SingleHeroSelectRow> singleHeroSelectRows, OnRowClickListener onRowClickListener) {
        this.singleHeroSelectRows = singleHeroSelectRows;
        this.onRowClickListener = onRowClickListener;
        this.inflater = LayoutInflater.from(context);
        this.initialItems = new ArrayList<>();
        this.initialItems.addAll(singleHeroSelectRows);
    }
    public SingleHeroSelectRowAdapter(Context context, List<SingleHeroSelectRow> singleHeroSelectRows) {
        this.singleHeroSelectRows = singleHeroSelectRows;
        this.onRowClickListener = null;
        this.inflater = LayoutInflater.from(context);
        this.initialItems = new ArrayList<>();
        this.initialItems.addAll(singleHeroSelectRows);
    }
    @Override
    public SingleHeroSelectRowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.single_hero_select_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SingleHeroSelectRowAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SingleHeroSelectRow singleHeroSelectRow = singleHeroSelectRows.get(position);
        holder.heroImage.setImageResource(singleHeroSelectRow.getHeroImage());
        holder.heroNameTextView.setText(singleHeroSelectRow.getHeroName());
        holder.heroWinrateTextView.setText(singleHeroSelectRow.getWinrate().toString());

        if(onRowClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    onRowClickListener.onRowClick(singleHeroSelectRow, position);

                }
            });
        }
        else{
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {}
            });
        }
    }

    @Override
    public int getItemCount() {
        return singleHeroSelectRows.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView heroImage;
        final TextView heroNameTextView, heroWinrateTextView;
        ViewHolder(View view){
            super(view);
            heroImage = view.findViewById(R.id.heroImage);
            heroNameTextView = view.findViewById(R.id.heroNameTextView);
            heroWinrateTextView = view.findViewById(R.id.heroWinrateTextView);
        }
    }
}

