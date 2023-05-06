package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;
import ru.mirea.savenkov.dota_client.dto.HeroWinrate;

public class StartSplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onResume() {
        super.onResume();


        new Thread(() -> DataManager.firstGetData(StartSplashActivity.this)).start();
        //Toast.makeText(this, "Загрузка данных..." , Toast.LENGTH_SHORT).show();

        int maxSeconds = 4, currentSeconds = 0;
        while(DataManager.getHeroWinrateList() == null || DataManager.getHeroDisadvantageList() == null){
            try {
                Thread.sleep(1000);
                currentSeconds += 1;
                if(currentSeconds == maxSeconds){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Intent intent = new Intent(this, MainActivity.class);
        //перемещаемся к существующей активити (если она есть)
        //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(getString(R.string.fromClassIntent),
                getString(R.string.startSplashActivityName));

        if(DataManager.getHeroDisadvantageList() != null && DataManager.getHeroWinrateList() != null){
            Toast.makeText(this, "Загрузка завершена." , Toast.LENGTH_SHORT).show();
        }
        else{
            //если за отведённое время данные не загрузились, то надо заменить их на пустоту (винрейт у всех 0, разница у всех - 0)
            //чтобы потом пользователь смог скачать данные снова.

            DataManager.fillWinrateEmpty();
            DataManager.fillDisadvantageEmpty();
            intent.putExtra(getString(R.string.downloadSuccessExtra),getString(R.string.downloadErrorExtraValue));
        }

        startActivity(intent);
        finish();
    }
}
