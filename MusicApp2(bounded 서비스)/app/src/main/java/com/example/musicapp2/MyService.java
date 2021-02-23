package com.example.musicapp2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private MediaPlayer mp;
    private final IBinder mBinder = new LocalBinder(); //바로 new Binder()를 쓰지 않는 이유는 여기서 선언한 래퍼런스 변수들을 사용하기 위해
    //컨텍스트를 리턴받기 위해

    class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
        MediaPlayer getMp(){
            return mp;
        }

    }

    public MyService() {
        LocalBinder b =(LocalBinder) mBinder;
        MyService m = b.getService();
        Log.d(TAG, "MyService: "+m.mp);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.sample1);
    }

    @Override
    public IBinder onBind(Intent intent) { //바인드를 한다는 건 MainActivity에서 서비스 제어가 가능함.
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}