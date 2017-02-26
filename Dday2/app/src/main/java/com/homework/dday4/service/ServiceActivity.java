package com.homework.dday4.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.homework.dday2.R;
import com.homework.dday4.service.MyService2;
import com.homework.dday4.service.MySevice;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class ServiceActivity extends Activity {
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {//电量

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.button1://启动式 与Activity无关
                Intent it1 = new Intent(this, MySevice.class);
                startService(it1);
                break;
            case R.id.button2://绑定式 和activity有关
                Intent it2= new Intent(this, MyService2.class);
                bindService(it2,conn,BIND_AUTO_CREATE);//会调用IBinder方法
                break;
        }

    }
}
