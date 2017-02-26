package com.homework.dday4.thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.homework.dday2.R;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class ThreadActivity extends Activity {
    private TextView tv;
    private Handler handler=new Handler(new Handler.Callback() {//因为主线程有Looper对象
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==1){
                tv.setText("xiaohong");
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        tv = (TextView) findViewById(R.id.tv);
    }

    //子线程给UI线程赋值，那我们该怎么传递数据

    /**
     * 子线程把消息封装成message,  handler是个搬运工把子线程中的message 搬运到消息队列（looper是看消息队列中是否有数据）中，
     *
     */
    public void click(View v) {
        switch (v.getId()){
            case R.id.button1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message m=Message.obtain();//创建一个对象是很耗时的，所以这样写比较节省内存
                        m.what=1;
                        //handler的作用是把消息放在消息队列中
                        handler.sendMessage(m);
                    }
                }).start();
                break;
            case R.id.button2:
                new MyTask(tv).execute(1,2,3,4,5,6);
                break;
        }



    }
}
