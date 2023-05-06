package ru.mirea.savenkov.dota_client.dataManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import ru.mirea.savenkov.dota_client.StartSplashActivity;
import ru.mirea.savenkov.dota_client.config.DotabuffInfo;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;
import ru.mirea.savenkov.dota_client.jsonHelper.JsonHelper;

public class DataManager extends AsyncTask<Context, Void, Void>{
    private final String TAG = DataManager.class.getSimpleName();
    private static DataManager instance;
    //private final String WINRATE_URL = "http://192.168.31.30:8080/dota/v1/winrate/get";
    //private final String DISADVANTAGE_URL = "http://192.168.31.30:8080/dota/v1/disadvantage/get";
    private final String WINRATE_URL = "http://10.0.2.2:8080/dota/v1/winrate/get";
    private final String DISADVANTAGE_URL = "http://10.0.2.2:8080/dota/v1/disadvantage/get";
    @SuppressLint("StaticFieldLeak")
    private Context context;
    public static void setInstanceNull(){
        instance = null;
    }

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
        Log.i(TAG, "(My) Get Data method");
        this.context = context;

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

        instance.cancel(false);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(context instanceof MainActivity){
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.fillChosenHeroesRecyclerView();
            mainActivity.fillHeroesListView();
        }
    }

    private String getJsonStr(String urlStr)  {
        Log.i(TAG, "(My) getJsonStr(from server)");
        StringBuilder result = new StringBuilder();
        try{
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            Log.i("TAG", "(My) response code: " + conn.getResponseCode());
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
            //Toast.makeText(context, context.getResources().getString(R.string.downloadErrorText), Toast.LENGTH_SHORT).show();
            Log.e(TAG, "(My) can't get info from server.");
            //throw new RuntimeException(context.getResources().getString(R.string.downloadErrorText) + ": " + urlStr);
            return null;
        }
    }

    public List<HeroWinrate> getHeroWinrateList() {
        //Log.i(TAG, "(My) getter getHeroWinrateList, null: " + String.valueOf(heroWinrateList == null));
        return heroWinrateList;
    }

    public List<HeroDisadvantage> getHeroDisadvantageList() {
        //Log.i(TAG, "(My) getter getHeroDisadvantageList, null: " + String.valueOf(heroDisadvantageList == null));
        return heroDisadvantageList;
    }

    public Map<String, HeroWinrate> getHeroWinrateMap() {
        return heroWinrateMap;
    }

    @Override
    protected Void doInBackground(Context... contexts) {
        Log.i(TAG, "(My) doInBackground method");
        if(contexts.length != 1){
            throw new RuntimeException("(My) Not a single main activity.");
        }
        try {
            Log.i(TAG, "(My) doInBackground method: trying to get data.");
            getData(contexts[0]);
            Log.i(TAG, "(My) doInBackground method: data get success.");
        } catch (IOException e) {
            Log.e(TAG, "(My) getData error.");
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
