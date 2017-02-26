package com.homework.dday4.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.homework.dday2.R;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class BroadActivity extends Activity {
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getExtras().getString("name");
            //Toast.makeText(context, "无序广播" + message, Toast.LENGTH_SHORT).show();
            //Toast.makeText(context, "粘滞广播----" + message, Toast.LENGTH_SHORT).show();
            abortBroadcast();//终止广播



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
    }

    public void click(View v) {
        switch (v.getId()) {
            //先注册后发送
            case R.id.button1://广播接收者-注册
                IntentFilter filter = new IntentFilter();
                filter.addAction("mouse");
                registerReceiver(receiver, filter);
                break;
            case R.id.button2://广播发送者
                Intent intent = new Intent();
                intent.setAction("mouse");
                intent.putExtra("name", "123");
                sendBroadcast(intent);
//                sendOrderedBroadcast(intent, null);
                break;
            //先发送后注册
            case R.id.button3://先发送后接收
                Intent intent2 = new Intent();
                intent2.setAction("laymen");
                intent2.putExtra("name", "李四");
//              sendBroadcast(intent2);
//              sendOrderedBroadcast(intent2,null);
                sendStickyBroadcast(intent2);//发送粘滞广播
                break;
            case R.id.button4:
                IntentFilter filter2 = new IntentFilter();
                filter2.addAction("laymen");
                registerReceiver(receiver, filter2);
                break;
        }

    }

    /**
     * 广播使用
     * 1.广播注册：1，通过代码进行注册 2，在清单文件中进行注册
     * 2.发送广播：发送数据
     * 广播的分类：
     * 1.无序广播 ：先进行注册广播接受者
     * 2有序广播 ：先进行注册，需要设置优先级（优先级高的先接收广播，依次向下传递数据，传递的过程中可以修改内容或者终止广播）
     * 3.粘滞广播：不需要先进行注册，可以在广播发送后在接收消息  是需要权限的
     */
}
