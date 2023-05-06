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
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
        return context.getFilesDir() + "/" + WINRATE_FILE_NAME;
        //return "/data/data/ru.mirea.savenkov.dota_client/files/winrate.json";
    }
    public static String getFullDisadvantagePath(Context context){
        //return Environment.getDataDirectory().getAbsolutePath() + "/" + DISADVANTAGE_FILE_NAME;
        return context.getFilesDir().getAbsolutePath() + "/" + DISADVANTAGE_FILE_NAME;
        //return "/data/data/ru.mirea.savenkov.dota_client/files/disadvantage.json";
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
        Log.i(TAG, "(My) Import from Disadvantage file.");
        String disadvantageFileName = getFullDisadvantagePath(context);
        File disadvantageFile = new File(disadvantageFileName);
        if(!disadvantageFile.exists()){
            Log.e(TAG, "(My) Disadvantage file does not exist.");
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
            Log.e(TAG, "(My) Cant get data items in disadvantage json.");
            ex.printStackTrace();
        }

        return null;
    }

    public static List<HeroWinrate> importFromJsonWinrate(Context context) {
        Log.i(TAG, "(My) Import from Winrate file.");
        String winrateFileName = getFullWinratePath(context);
        File winrateFile = new File(winrateFileName);
        if(!winrateFile.exists()){
            Log.w(TAG, "(My) Winrate file does not exist.");
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
            Log.e(TAG, "(My) Cant get data items in winrate json.");
            ex.printStackTrace();
        }

        return null;
    }
    public static boolean exportToJsonWinrateString(Context context, String jsonString){
        Log.i(TAG, "(My) Export to Json Winrate string.");
        String winrateFileName = getFullWinratePath(context);
        File winrateFile = new File(winrateFileName);
        if(!winrateFile.exists()){
            try {
                if(!winrateFile.createNewFile()){
                    Log.w(TAG, "(My) Can't create winrate file.");
                    throw new RuntimeException("Can't create " + WINRATE_FILE_NAME + "file.");
                }
            } catch (IOException e) {
                Log.w(TAG, "(My) Winrate file does not exist.");
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
        Log.i(TAG, "(My) Export to Json Disadvantage string.");
        String disadvantageFileName = getFullDisadvantagePath(context);
        File disadvantageFile = new File(disadvantageFileName);
        if(!disadvantageFile.exists()){
            try {
                if(!disadvantageFile.createNewFile()){
                    Log.w(TAG, "(My) Can't create disadvantage file.");
                }
            } catch (IOException e) {
                Log.w(TAG, "(My) Disadvantage file does not exist.");
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
    public static boolean deleteWinrateFile(Context context){
        File file = new File(getFullWinratePath(context));
        return file.delete();
    }
    public static boolean deleteDisadvantageFile(Context context){
        File file = new File(getFullDisadvantagePath(context));
        return file.delete();
    }
}
