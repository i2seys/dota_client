package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;

public class StartSplashActivity extends AppCompatActivity {
    private DataManager dataManager = DataManager.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataManager.execute(this);
        Toast.makeText(this, "Загрузка данных..." , Toast.LENGTH_SHORT).show();

        int maxSeconds = 5, currentSeconds = 0;
        boolean loadingSuccess = false;
        while(dataManager.getHeroWinrateList() == null || dataManager.getHeroDisadvantageList() == null){
            try {
                Thread.sleep(1000);
                currentSeconds += 1;
                if(currentSeconds == maxSeconds){
                    loadingSuccess = false;
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Intent intent = new Intent(this, MainActivity.class);

        if(loadingSuccess){
            Toast.makeText(this, "Загрузка завершена." , Toast.LENGTH_SHORT).show();
        }
        else{
            //если за отведённое время данные не загрузились, то надо заменить их на пустоту (винрейт у всех 0, разница у всех - 0)
            //чтобы потом пользователь смог скачать данные снова.
            dataManager.cancel(false);
            dataManager.fillWinrateEmpty();
            dataManager.fillDisadvantageEmpty();

            intent.putExtra(getString(R.string.downloadSuccessExtra),getString(R.string.downloadErrorExtraValue));
        }

        startActivity(intent);
        finish();
    }
}
