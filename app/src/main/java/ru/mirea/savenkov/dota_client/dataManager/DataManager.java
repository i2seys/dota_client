package ru.mirea.savenkov.dota_client.dataManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
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

import ru.mirea.savenkov.dota_client.R;
import ru.mirea.savenkov.dota_client.StartSplashActivity;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.jsonHelper.JsonHelper;

public class DataManager extends  AsyncTask<StartSplashActivity, Void, Void>{
    private static DataManager instance;
    private final String WINRATE_URL = "http://10.0.2.2:8080/dota/v1/winrate/get";
    private final String DISADVANTAGE_URL = "http://10.0.2.2:8080/dota/v1/disadvantage/get";
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
    private List<HeroWinrate> heroWinrateList = null;
    private List<HeroDisadvantage> heroDisadvantageList = null;
    private Map<String, HeroWinrate> heroWinrateMap = null;
    private void getData(Context context) throws IOException {
        this.context = context;

        String jsonStr;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType;

        heroWinrateList = JsonHelper.importFromJsonWinrate(context);
        if(heroWinrateList == null){
            jsonStr = getJsonStr(WINRATE_URL);
            listType = new TypeToken<ArrayList<HeroWinrate>>(){}.getType();
            heroWinrateList = gson.fromJson(jsonStr, listType);

            JsonHelper.exportToJsonWinrateString(context, jsonStr);
        }
        heroWinrateMap = new HashMap<>();
        for(int i = 0; i < heroWinrateList.size(); i++){
            heroWinrateMap.put(heroWinrateList.get(i).getHero().getNiceHero(), heroWinrateList.get(i));
        }


        heroDisadvantageList = JsonHelper.importFromJsonDisadvantage(context);
        if(heroDisadvantageList == null){
            jsonStr = getJsonStr(DISADVANTAGE_URL);
            listType = new TypeToken<ArrayList<HeroDisadvantage>>(){}.getType();
            heroDisadvantageList = gson.fromJson(jsonStr, listType);

            JsonHelper.exportToJsonDisadvantageString(context, jsonStr);
        }
    }
    private String getJsonStr(String urlStr)  {
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
            return result.toString();
        }
        catch (IOException e){
            Toast.makeText(context, context.getResources().getString(R.string.downloadErrorText), Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(context.getResources().getString(R.string.downloadErrorText) + ": " + urlStr);
        }
    }

    public List<HeroWinrate> getHeroWinrateList() {
        return heroWinrateList;
    }

    public List<HeroDisadvantage> getHeroDisadvantageList() {
        return heroDisadvantageList;
    }

    public Map<String, HeroWinrate> getHeroWinrateMap() {
        return heroWinrateMap;
    }

    @Override
    protected Void doInBackground(StartSplashActivity... startSplashActivities) {
        if(startSplashActivities.length != 1){
            throw new RuntimeException("Not a single main activity.");
        }
        try {
            getData(startSplashActivities[0]);
        } catch (IOException e) {
            Toast.makeText(startSplashActivities[0],
                    context.getResources().getString(R.string.downloadErrorText),
                    Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return null;
    }

    public void fillWinrateEmpty() {
        heroWinrateList = new ArrayList<>(DotabuffInfo.heroesCount);
        for(int i = 0; i < DotabuffInfo.heroesCount; i++){
            heroWinrateList.add(new HeroWinrate(i, DotabuffInfo.HEROES.values()[i], 0.0));
        }
    }
    public void fillDisadvantageEmpty() {
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
}
