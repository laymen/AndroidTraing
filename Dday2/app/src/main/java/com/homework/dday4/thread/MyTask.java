package com.homework.dday4.thread;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class MyTask extends AsyncTask<Integer,Void,String> {
    private String TAG="MyTask";
    public TextView tv;
    public MyTask(TextView tv){
        this.tv=tv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 子线程 耗时操作
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Integer... params) {
        publishProgress();//当调用publishProgress时调用onProgressUpdate
        Log.i(TAG,"---------------------------------"+params.length);
        return "pig";
    }

    /**
     * 主线程
     * @param values
     */
    @Override
    protected void onProgressUpdate(Void... values) {//主线程
        super.onProgressUpdate(values);
    }

    /**
     * 处理doInBackground 传递的数据
     * @param result
     */
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i(TAG,"---------------------------------"+result);
        tv.setText(result);

    }
}
