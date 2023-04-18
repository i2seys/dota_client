package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;

public class StartSplashActivity extends AppCompatActivity {
    private DataManager dataManager = DataManager.getInstance();
    private TextView progressText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        dataManager.execute(new StartSplashActivity[]{this});

        Intent intent = new Intent(this, MainActivity.class);
        progressText = findViewById(R.id.progressTextView);
        while(dataManager.getHeroWinrateList() == null || dataManager.getHeroDisadvantageList() == null){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        progressText.setText("Загрузка завершена.");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 700);
        //setContentView(R.layout.activity_main);
    }
}
