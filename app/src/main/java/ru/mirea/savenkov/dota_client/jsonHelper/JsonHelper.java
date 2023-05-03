package ru.mirea.savenkov.dota_client.jsonHelper;

import android.content.Context;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;

public class JsonHelper {
    private static final String TAG = JsonHelper.class.getSimpleName();
    public static final String DISADVANTAGE_FILE_NAME =  "disadvantage.json";
    public static final String WINRATE_FILE_NAME = "winrate.json"; //getFilesDir()
    public static String getFullWinratePath(Context context){
        //return Environment.getDataDirectory().getAbsolutePath() + "/" + WINRATE_FILE_NAME;
        //return context.getFilesDir().getAbsolutePath() + "/" + WINRATE_FILE_NAME;
        return "/data/data/ru.mirea.savenkov.dota_client/files/winrate.json";
    }
    public static String getFullDisadvantagePath(Context context){
        //return Environment.getDataDirectory().getAbsolutePath() + "/" + DISADVANTAGE_FILE_NAME;
        //return context.getFilesDir().getAbsolutePath() + "/" + DISADVANTAGE_FILE_NAME;
        return "/data/data/ru.mirea.savenkov.dota_client/files/disadvantage.json";
    }
    public static boolean exportToJsonDisadvantage(Context context, List<HeroDisadvantage> dataList) {
        String disadvantageFileName = getFullDisadvantagePath(context);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dataList);

        File disadvantageFile = new File(disadvantageFileName);
        if(!disadvantageFile.exists()){
            return false;
        }

        try(FileOutputStream fileOutputStream =
                    context.openFileOutput(disadvantageFileName, Context.MODE_PRIVATE)) {
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean exportToJsonWinrate(Context context, List<HeroWinrate> dataList) {
        String winrateFileName = getFullWinratePath(context);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dataList);

        File winrateFile = new File(winrateFileName);
        if(!winrateFile.exists()){
            return false;
        }

        try(FileOutputStream fileOutputStream =
                    context.openFileOutput(winrateFileName, Context.MODE_PRIVATE)) {
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<HeroDisadvantage> importFromJsonDisadvantage(Context context) {
        Log.i(TAG, "Import from Disadvantage file (My).");
        String disadvantageFileName = getFullDisadvantagePath(context);
        File disadvantageFile = new File(disadvantageFileName);
        if(!disadvantageFile.exists()){
            Log.e(TAG, "Disadvantage file does not exist (My).");
            return null;
        }

        try(FileInputStream fileInputStream = new FileInputStream (disadvantageFileName);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream)){

            Gson gson = new Gson();
            Type listType = new TypeToken<List<HeroDisadvantage>>() {}.getType();

            List<HeroDisadvantage> dataItems = gson.fromJson(streamReader, listType);
            return dataItems;
        }
        catch (IOException ex){
            Log.e(TAG, "Cant get data items in disadvantage json (My).");
            ex.printStackTrace();
        }

        return null;
    }

    public static List<HeroWinrate> importFromJsonWinrate(Context context) {
        Log.i(TAG, "Import from Winrate file (My).");
        String winrateFileName = getFullWinratePath(context);
        File winrateFile = new File(winrateFileName);
        if(!winrateFile.exists()){
            Log.e(TAG, "Winrate file does not exist (My).");
            return null;
        }

        try(FileInputStream fileInputStream = new FileInputStream (winrateFileName);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream)){

            Gson gson = new Gson();
            Type listType = new TypeToken<List<HeroWinrate>>() {}.getType();

            List<HeroWinrate> dataItems = gson.fromJson(streamReader, listType);
            return dataItems;
        }
        catch (IOException ex){
            Log.e(TAG, "Cant get data items in winrate json (My).");
            ex.printStackTrace();
        }

        return null;
    }
    public static boolean exportToJsonWinrateString(Context context, String jsonString){
        Log.i(TAG, "Export to Json Winrate string (My)");
        String winrateFileName = getFullWinratePath(context);
        File winrateFile = new File(winrateFileName);
        if(!winrateFile.exists()){
            try {
                if(!winrateFile.createNewFile()){
                    Log.w(TAG, "Can't create winrate file (My)");
                    throw new RuntimeException("Can't create " + WINRATE_FILE_NAME + "file.");
                }
            } catch (IOException e) {
                Log.w(TAG, "Winrate file does not exist (My)");
                e.printStackTrace();
                return false;
            }
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(winrateFileName)))
        {
            bw.write(jsonString);
            return true;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
    public static boolean exportToJsonDisadvantageString(Context context, String jsonString){
        Log.i(TAG, "Export to Json Disadvantage string (My)");
        String disadvantageFileName = getFullDisadvantagePath(context);
        File disadvantageFile = new File(disadvantageFileName);
        if(!disadvantageFile.exists()){
            try {
                if(!disadvantageFile.createNewFile()){
                    Log.w(TAG, "Can't create disadvantage file (My)");
                    throw new RuntimeException("Can't create " + DISADVANTAGE_FILE_NAME + "file.");
                }
            } catch (IOException e) {
                Log.w(TAG, "Disadvantage file does not exist (My)");
                e.printStackTrace();
                return false;
            }
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(disadvantageFileName)))
        {
            bw.write(jsonString);
            return true;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
