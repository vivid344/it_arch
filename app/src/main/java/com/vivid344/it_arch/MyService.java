package com.vivid344.it_arch;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;


public class MyService extends Service {
    public MyService() {
    }

    private final static String TAG = String.class.getSimpleName();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        public void ShowToast(String input) {
            try {
                int dec = Integer.parseInt(input);
                String hex = Integer.toHexString(dec);
                Toast toast = Toast.makeText(getApplicationContext(), hex, Toast.LENGTH_SHORT);
                toast.show();
            }catch (NumberFormatException e){
                Toast toast = Toast.makeText(getApplicationContext(), "数字を入力してください", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    };
}
