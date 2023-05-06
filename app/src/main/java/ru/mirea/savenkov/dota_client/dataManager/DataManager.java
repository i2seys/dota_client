package ru.mirea.savenkov.dota_client.dataManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.savenkov.dota_client.MainActivity;
import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.jsonHelper.JsonHelper;

public class DataManager{
    private static final String TAG = DataManager.class.getSimpleName();
    //private final String WINRATE_URL = "http://192.168.31.30:8080/dota/v1/winrate/get";
    //private final String DISADVANTAGE_URL = "http://192.168.31.30:8080/dota/v1/disadvantage/get";
    private static  final String WINRATE_URL = "http://10.0.2.2:8080/dota/v1/winrate/get";
    private static final String DISADVANTAGE_URL = "http://10.0.2.2:8080/dota/v1/disadvantage/get";
    private static List<HeroWinrate> heroWinrateList = null;
    private static List<HeroDisadvantage> heroDisadvantageList = null;
    private static Map<String, HeroWinrate> heroWinrateMap = null;
    public static void secondGetData(Context context){
        Log.i(TAG, "(My) Second get Data method");
        if(context instanceof MainActivity){
            Log.i(TAG, "(My) Context instanceof MainActivity: true");
            MainActivity mainActivity = (MainActivity) context;
            List<HeroWinrate> tempWinrate;
            List<HeroDisadvantage> tempDisadvantage;
            Map<String, HeroWinrate> tempWinrateMap;


            String jsonStrWinrate, jsonStrDisadvantage;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Type listType;


            Log.i(TAG, "(My) Trying to get winrate info from server).");
            jsonStrWinrate = getJsonStr(WINRATE_URL);
            if(jsonStrWinrate == null){
                Log.e(TAG,"(My) can't get winrate info from server, return from function");
                mainActivity.runOnUiThread(() -> Toast.makeText(mainActivity, "Во время загрузки произошла ошибка, повторите позже.", Toast.LENGTH_SHORT).show());
                return;
            }
            listType = new TypeToken<ArrayList<HeroWinrate>>(){}.getType();
            tempWinrate = gson.fromJson(jsonStrWinrate, listType);
            //JsonHelper.exportToJsonWinrateString(context, jsonStr);!!!
            tempWinrateMap = new HashMap<>();
            for(int i = 0; i < tempWinrate.size(); i++){
                tempWinrateMap.put(heroWinrateList.get(i).getHero().getNiceHero(), heroWinrateList.get(i));
            }
            Log.i(TAG, "(My) Winrate info: success.");


            Log.i(TAG, "(My) Trying to get disadvantage info from server)");
            jsonStrDisadvantage = getJsonStr(DISADVANTAGE_URL);
            if(jsonStrDisadvantage == null){
                Log.e(TAG,"(My) can't get disadvantage info from server, return from function");
                mainActivity.runOnUiThread(() -> Toast.makeText(mainActivity, "Во время загрузки произошла ошибка, повторите позже.", Toast.LENGTH_SHORT).show());
                return;
            }
            listType = new TypeToken<ArrayList<HeroDisadvantage>>(){}.getType();
            tempDisadvantage = gson.fromJson(jsonStrDisadvantage, listType);
            Log.i(TAG, "(My) Disadvantage info: success.");


            if(tempDisadvantage != null
                    && tempWinrate.size() == DotabuffInfo.heroesCount
                    && tempWinrateMap.size() == DotabuffInfo.heroesCount
                    && tempDisadvantage.size() == DotabuffInfo.heroesCount * (DotabuffInfo.heroesCount - 1)){
                Log.i(TAG, "(My) Data pull: correct.");
                heroDisadvantageList = tempDisadvantage;
                heroWinrateList = tempWinrate;
                heroWinrateMap = tempWinrateMap;
                JsonHelper.deleteDisadvantageFile(mainActivity);
                JsonHelper.deleteWinrateFile(mainActivity);
                JsonHelper.exportToJsonDisadvantageString(mainActivity, jsonStrDisadvantage);
                JsonHelper.exportToJsonWinrateString(mainActivity, jsonStrWinrate);
                mainActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        mainActivity.fillChosenHeroesRecyclerView();
                        mainActivity.fillHeroesListView();
                        mainActivity.getIntent().removeExtra(mainActivity.getString(R.string.downloadSuccessExtra));
                        Log.i(TAG, "(My) mainActivity recycler views filled.");
                        Toast.makeText(mainActivity, "Загрузка завершена.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else{
                Log.w(TAG, "(My)  Data pull: error.");
                mainActivity.runOnUiThread(() -> Toast.makeText(mainActivity, "Во время загрузки произошла ошибка, повторите позже.", Toast.LENGTH_SHORT).show());
            }
        }
    }
    public static void firstGetData(Context context) {
        Log.i(TAG, "(My) First get Data method");

        String jsonStr;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType;

        heroWinrateList = JsonHelper.importFromJsonWinrate(context);
        if(heroWinrateList == null){
            Log.i(TAG, "(My) Hero winrate list null (cant import from json, trying to get from server)");

            jsonStr = getJsonStr(WINRATE_URL);
            if(jsonStr == null){
                Log.e(TAG,"(My) can't get info from server, return from function");
                return;
            }
            listType = new TypeToken<ArrayList<HeroWinrate>>(){}.getType();
            heroWinrateList = gson.fromJson(jsonStr, listType);

            JsonHelper.exportToJsonWinrateString(context, jsonStr);
        }
        else{
            Log.i(TAG, "(My) Hero winrate list imported from json");
        }
        heroWinrateMap = new HashMap<>();
        for(int i = 0; i < heroWinrateList.size(); i++){
            heroWinrateMap.put(heroWinrateList.get(i).getHero().getNiceHero(), heroWinrateList.get(i));
        }


        heroDisadvantageList = JsonHelper.importFromJsonDisadvantage(context);
        if(heroDisadvantageList == null){
            Log.i(TAG, "(My) Hero disadvantage list null (cant import from json, trying to get from server)");
            jsonStr = getJsonStr(DISADVANTAGE_URL);
            if(jsonStr == null){
                Log.e(TAG,"(My) can't get info from server, return from function");
                return;
            }
            listType = new TypeToken<ArrayList<HeroDisadvantage>>(){}.getType();
            heroDisadvantageList = gson.fromJson(jsonStr, listType);

            JsonHelper.exportToJsonDisadvantageString(context, jsonStr);
        }
        else{
            Log.i(TAG, "(My) Hero disadvantage list imported from json");
        }

        if(getHeroWinrateList() != null && getHeroWinrateList().size() == DotabuffInfo.heroesCount
        && getHeroDisadvantageList() != null && getHeroDisadvantageList().size() == DotabuffInfo.heroesCount * (DotabuffInfo.heroesCount - 1)){
            Log.i(TAG,"(My) Information pull(server or json): success.");
        }
        else{
            Log.w(TAG,"(My) Information pull(server or json): error.");
        }

    }

    private static String getJsonStr(String urlStr)  {
        Log.i(TAG, "(My) getJsonStr(from server)");
        StringBuilder result = new StringBuilder();
        try{
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            Log.i(TAG, "(My) info get: successful.");
            return result.toString();
        }
        catch (IOException e){
            Log.e(TAG, "(My) can't get info from server.");
            return null;
        }
    }

    public static List<HeroWinrate> getHeroWinrateList() {
        //Log.i(TAG, "(My) getter getHeroWinrateList, null: " + String.valueOf(heroWinrateList == null));
        return heroWinrateList;
    }

    public static List<HeroDisadvantage> getHeroDisadvantageList() {
        //Log.i(TAG, "(My) getter getHeroDisadvantageList, null: " + String.valueOf(heroDisadvantageList == null));
        return heroDisadvantageList;
    }

    public static Map<String, HeroWinrate> getHeroWinrateMap() {
        return heroWinrateMap;
    }


    public static void fillWinrateEmpty() {
        heroWinrateList = new ArrayList<>(DotabuffInfo.heroesCount);
        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            heroWinrateList.add(new HeroWinrate(i, DotabuffInfo.HEROES.values()[i], 0.0));
        }
    }
    public static void fillDisadvantageEmpty() {
        int size = DotabuffInfo.heroesCount * (DotabuffInfo.heroesCount - 1);
        heroDisadvantageList = new ArrayList<>(size);
        int id = 0;
        DotabuffInfo.HEROES[] heroes = DotabuffInfo.HEROES.values();

        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            for(int j = 0; j < DotabuffInfo.heroesCount; j++){
                if(j == i) {
                    continue;
                }

                heroDisadvantageList.add(new HeroDisadvantage(id, heroes[j], heroes[i], 0.0));
                id++;
            }
        }
    }
    public static boolean isWinrateListEmpty(List<HeroWinrate> heroWinrateList){
        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            if(heroWinrateList.get(i).getWinrate() != 0.0
                    || !heroWinrateList.get(i).getHero().equals(
                            DotabuffInfo.HEROES.values()[i])
                    || heroWinrateList.get(i).getId() != i){
                return false;
            }
        }
        return true;
    }
    public static boolean isDisadvantageListEmpty(List<HeroDisadvantage> heroDisadvantageList){
        int id = 0;
        DotabuffInfo.HEROES[] heroes = DotabuffInfo.HEROES.values();

        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            for(int j = 0; j < DotabuffInfo.heroesCount; j++){
                if(j == i) {
                    continue;
                }
                if(heroDisadvantageList.get(id).getId() != id
                    || !heroDisadvantageList.get(id).getInnerHero().equals(heroes[j])
                    || !heroDisadvantageList.get(id).getOuterHero().equals(heroes[i])
                    || heroDisadvantageList.get(id).getPercent() != 0.0){
                        return false;
                }

                id++;
            }
        }
        return true;
    }
}
