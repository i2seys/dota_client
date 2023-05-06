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

import ru.mirea.savenkov.dota_client.CounterpicksActivity;
import ru.mirea.savenkov.dota_client.MainActivity;
import ru.mirea.savenkov.dota_client.R;

public class SingleHeroSelectRowAdapter extends  RecyclerView.Adapter<SingleHeroSelectRowAdapter.ViewHolder>{
    private enum COMPARATION{
        NAME,
        VALUE
    }
    private final LayoutInflater inflater;
    private final List<SingleHeroSelectRow> singleHeroSelectRows;
    private final OnRowClickListener onRowClickListener;
    private final List<SingleHeroSelectRow> initialItems;
    private final Class layoutClass;

    public interface OnRowClickListener{
        void onRowClick(SingleHeroSelectRow singleHeroSelectRow, int position);
    }
    private int compareHeroesSelectRows(SingleHeroSelectRow i1, SingleHeroSelectRow i2, COMPARATION comparation){
        if(comparation.equals(COMPARATION.NAME)){
            return i1.getHeroName().compareTo(i2.getHeroName());
        }
        else{
            return -i1.getValue().compareTo(i2.getValue());
        }

    }
    public boolean addItem(SingleHeroSelectRow item, RecyclerView heroToChooseView){
        String searchText = "";
        COMPARATION comparation;
        if(layoutClass.equals(MainActivity.class)){
            searchText = MainActivity.searchView.getQuery().toString();
            //находим индекс для вставки
            comparation = COMPARATION.NAME;
        }
        else {//if(layoutClass.equals(CounterpicksActivity.class)){
            searchText = CounterpicksActivity.searchView.getQuery().toString();
            comparation = COMPARATION.VALUE;
        }

        boolean actualRowAdded = false;
        int heroSelectRowsIndex = -1;
        if(searchText.isEmpty() || item.getHeroName().toLowerCase().contains(searchText.toLowerCase())) {
            if (singleHeroSelectRows.size() == 0) {
                //если стоит фильтр, который убирает вообще все данные (фильтр abaddon, но abaddon уже выбран)
                heroSelectRowsIndex = 0;
                actualRowAdded = true;
            } else {
                if (compareHeroesSelectRows(item, singleHeroSelectRows.get(0), comparation) < 0) {
                    heroSelectRowsIndex = 0;
                    actualRowAdded = true;
                } else if (compareHeroesSelectRows(item, singleHeroSelectRows.get(singleHeroSelectRows.size() - 1), comparation) > 0) {
                    heroSelectRowsIndex = singleHeroSelectRows.size();
                    actualRowAdded = true;
                } else {
                    for (int i = 0; i < singleHeroSelectRows.size() - 1; i++) {
                        if (compareHeroesSelectRows(item, singleHeroSelectRows.get(i), comparation) >= 0 &&
                                compareHeroesSelectRows(item, singleHeroSelectRows.get(i+1), comparation) < 0) {
                            heroSelectRowsIndex = i + 1;
                            actualRowAdded = true;
                            break;
                        }
                    }
                }
            }
        }
        if (heroSelectRowsIndex == -1) {
            actualRowAdded = false;
        }

        boolean initialRowAdded = false;
        int initialIndex = -1;
        if(compareHeroesSelectRows(item, initialItems.get(0), comparation) < 0){
            initialIndex = 0;
            initialRowAdded = true;
        }
        else if (compareHeroesSelectRows(item, initialItems.get(initialItems.size() - 1), comparation) > 0){
            initialIndex = initialItems.size();
            initialRowAdded = true;
        }
        else{
            for(int i = 0; i < initialItems.size()-1; i++){
                if(compareHeroesSelectRows(item, initialItems.get(i), comparation) >= 0 &&
                        compareHeroesSelectRows(item, initialItems.get(i+1), comparation) < 0){
                    initialIndex = i + 1;
                    initialRowAdded = true;
                    break;
                }
            }
        }
        if(initialIndex == -1){
            initialRowAdded = false;
        }

        // init act f
        //  0    0  false
        //  0    1  exc
        //  1    0  exc
        //  1    1

        if(!initialRowAdded && !actualRowAdded){
            return false;
        }
        else{
            if(actualRowAdded){
                singleHeroSelectRows.add(heroSelectRowsIndex, item);
                notifyItemInserted(heroSelectRowsIndex);
            }
            initialItems.add(initialIndex, item);
            return true;
        }

    }

    public boolean removeItem(SingleHeroSelectRow item){
        boolean rowsDeleted = false;
        for(int i = 0; i < singleHeroSelectRows.size(); i++){
            if(item.equals(singleHeroSelectRows.get(i))){
                singleHeroSelectRows.remove(i);
                notifyItemRemoved(i);
                rowsDeleted = true;
                break;
            }
        }
        boolean initialDeleted = false;
        for(int i = 0; i < initialItems.size(); i++){
            if(item.equals(initialItems.get(i))){
                initialItems.remove(i);
                initialDeleted = true;
                break;
            }
        }
        if(!initialDeleted && !rowsDeleted){
            return false;
        }
        else if(!initialDeleted || !rowsDeleted){
            throw new RuntimeException("?????");
        }
        else{
            return true;
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
        this.layoutClass = context.getClass();
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
        double value = singleHeroSelectRow.getValue();
        if(inflater.getContext() instanceof MainActivity){
            holder.heroWinrateTextView.setText(String.format("%s%%", value));
        }
        else{
            holder.heroWinrateTextView.setText(String.valueOf(value));
        }
        int color;
        if(layoutClass.equals(MainActivity.class)){
            if(value > 50.0) {
                color = inflater.getContext().getResources().getColor(R.color.green);
            }
            else{
                color = inflater.getContext().getResources().getColor(R.color.red);
            }
        }
        else if(layoutClass.equals(CounterpicksActivity.class)){
            if(value > 0) {
                color = inflater.getContext().getResources().getColor(R.color.green);
            }
            else{
                color = inflater.getContext().getResources().getColor(R.color.red);
            }
        }
        else{
            throw new RuntimeException();
        }
        holder.heroWinrateTextView.setTextColor(color);

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

