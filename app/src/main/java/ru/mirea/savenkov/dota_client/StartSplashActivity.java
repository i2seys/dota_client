package ru.mirea.savenkov.dota_client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;

public class StartSplashActivity extends AppCompatActivity {
    private DataManager dataManager = DataManager.getInstance();
    private TextView progressText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        progressText = findViewById(R.id.progressTextView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        dataManager.execute(new StartSplashActivity[]{this});
        Toast.makeText(this, "Загрузка данных..." , Toast.LENGTH_SHORT).show();

        while(dataManager.getHeroWinrateList() == null || dataManager.getHeroDisadvantageList() == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        progressText.setText("Загрузка завершена.");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(intent);
//                finish();
//            }
//        }, 550);
    }
}
