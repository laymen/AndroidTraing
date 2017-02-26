package com.homework.dday4.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class MyBroadReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message=intent.getExtras().getString("name");
        Toast.makeText(context,"常驻型广播"+message,Toast.LENGTH_SHORT).show();
        //终止或更改


    }
}
