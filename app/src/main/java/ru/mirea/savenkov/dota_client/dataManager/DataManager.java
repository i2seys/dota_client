package ru.mirea.savenkov.dota_client.dataManager;

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

import ru.mirea.savenkov.dota_client.StartSplashActivity;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.jsonHelper.JsonHelper;

public class DataManager extends  AsyncTask<StartSplashActivity, Void, Void>{
    private static DataManager instance;
    private final String WINRATE_URL = "http://10.0.2.2:8080/dota/v1/winrate/get";
    private final String DISADVANTAGE_URL = "http://10.0.2.2:8080/dota/v1/disadvantage/get";

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
        StartSplashActivity startSplashActivity = (StartSplashActivity) context;

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
    private String getJsonStr(String urlStr) throws IOException {
        StringBuilder result = new StringBuilder();
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
                    "Невозможно получить данные с удалённого сервера. Повторите позже.",
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
}
