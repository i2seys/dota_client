package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;

public class StartSplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataManager.getInstance().execute(this);
        //Toast.makeText(this, "Загрузка данных..." , Toast.LENGTH_SHORT).show();

        int maxSeconds = 10, currentSeconds = 0;
        while(DataManager.getInstance().getHeroWinrateList() == null || DataManager.getInstance().getHeroDisadvantageList() == null){
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

        if(DataManager.getInstance().getHeroDisadvantageList() != null && DataManager.getInstance().getHeroWinrateList() != null){
            //Toast.makeText(this, "Загрузка завершена." , Toast.LENGTH_SHORT).show();
        }
        else{
            //если за отведённое время данные не загрузились, то надо заменить их на пустоту (винрейт у всех 0, разница у всех - 0)
            //чтобы потом пользователь смог скачать данные снова.
            DataManager.getInstance().cancel(false);
            DataManager.getInstance().fillWinrateEmpty();
            DataManager.getInstance().fillDisadvantageEmpty();

            intent.putExtra(getString(R.string.downloadSuccessExtra),getString(R.string.downloadErrorExtraValue));
        }

        startActivity(intent);
        finish();
    }
}
