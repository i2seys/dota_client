package ru.mirea.savenkov.dota_client.progressDialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.io.IOException;

import ru.mirea.savenkov.dota_client.MainActivity;
import ru.mirea.savenkov.dota_client.dataManager.DataManager;

public class DownloadProgressDialog extends ProgressDialog {
    private DataManager dataManager = DataManager.getInstance();

    public DownloadProgressDialog(Context context) {
        super(context);
        setMessage("Получение данных с сервера...");
        setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        setMax(100);
        setProgress(0);
    }
}
