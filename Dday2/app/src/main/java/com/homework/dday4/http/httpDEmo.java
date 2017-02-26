package com.homework.dday4.http;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.homework.dday2.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
/**
 * jsonobject:{k1:v1,k2:v2}
 * jsonArray{1,2,3,4,5}
 */

/**
 * Created by Administrator on 2017/2/23 0023.
 */
public class httpDEmo extends Activity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        iv = (ImageView) findViewById(R.id.img);
    }

    public void click(View v){
        switch (v.getId()) {
            case R.id.button:
               try {
                   URL url = new URL("");
                   URLConnection conn = url.openConnection();
                   InputStream in = conn.getInputStream();
                   //将留对象转化成bitmap对象
                   Bitmap bitmap = BitmapFactory.decodeStream(in);
               }catch (Exception e){
                   e.printStackTrace();
               }
                break;
            case R.id.get:
                HttpClient client=new DefaultHttpClient();
                HttpGet get=new HttpGet("url");
                try {
                    HttpResponse resp=client.execute(get);
                    int code=resp.getStatusLine().getStatusCode();
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;

            case R.id.post:
                HttpClient client1=new DefaultHttpClient();
                HttpPost post=new HttpPost("");
                //http://www.taobao.com/xxx,html?name=?&pwd=?
                List<NameValuePair> list=new ArrayList<>();
                list.add(new BasicNameValuePair("name","小明"));
                list.add(new BasicNameValuePair("pwd","123"));
                UrlEncodedFormEntity entity=null;
                try {
                    entity=new UrlEncodedFormEntity(list, HTTP.UTF_8);
                    post.setEntity(entity);
                    HttpResponse response=client1.execute(post);
                    int code=response.getStatusLine().getStatusCode();
                    if (code==200){
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.jiexi:
                String str="";
                break;
        }


    }
}
