package ru.mirea.savenkov.dota_client;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ru.mirea.savenkov.dota_client.dataManager.DataManager;
import ru.mirea.savenkov.dota_client.dto.HeroDisadvantage;

public class MainActivity extends AppCompatActivity {
    private DataManager dataManager = DataManager.getInstance();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ПОЧИТАТЬ https://stackoverflow.com/questions/45373007/progressdialog-is-deprecated-what-is-the-alternate-one-to-use
        // проблема: файлы не успевают импортироваться. вылетает ошибка (если файлов до этого не было)
        new Thread(() -> {
            try {
                dataManager.getData(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text);
        tv.setText(dataManager.getHeroWinrateList().get(2).toString());
    }

    public void btnClick(View view) {
        tv.setText(dataManager.getHeroWinrateList().get(16).toString());
    }
}