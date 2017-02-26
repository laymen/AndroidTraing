package com.mouse.weather;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                String [] a=msg.obj.toString().split("//");
                today.setText(a[0]);
                furture.setText(a[1]);
            }
            return false;
        }
    });
    private Spinner spinner;
    private TextView today;
    private TextView furture;
    private Button search;
    StringBuffer sb = null;

    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        today = (TextView) findViewById(R.id.today);
        furture = (TextView) findViewById(R.id.future);

        search = (Button) findViewById(R.id.search);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] cityNames = getResources().getStringArray(R.array.city);//可以获得xml中的数据
                String cityName = cityNames[position] + "";
                sb = new StringBuffer();
                sb.append("http://v.juhe.cn/weather/index?");
                sb.append("cityname=");
                sb.append(cityName);
                sb.append("&&dtype=json&format=1&key=352a0eb5f65e2962945ddfbd925dbca4");
                Log.i("mouse--mouse----", sb.toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void click(View v) {
        Log.i("mouse------", "");
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (sb != null) {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet get = new HttpGet(sb.toString());
                    try {
                        HttpResponse resp = client.execute(get);
                        //响应码
                        int code = resp.getStatusLine().getStatusCode();
                        if (code == 200) {
                            String result =
                                    EntityUtils.toString(resp.getEntity());

                            //拿到数据进行解析
                            JSONObject jsonObject = new JSONObject(result);
                            JSONObject result1 = jsonObject.getJSONObject("result");
                            JSONObject sk = result1.getJSONObject("sk");
                            JSONObject today = result1.getJSONObject("today");
                            //拼接今天的天气
                            String todayShow = today.getString("temperature") + "," + today.getString("weather") + "," + sk.getString("wind_direction") + sk.getString("wind_strength")
                                    + ",时间：" + sk.getString("time");
                            JSONObject future = result1.getJSONObject("future");
                            JSONObject no1 = future.getJSONObject("day_" + nextDay(1));
                            JSONObject no2 = future.getJSONObject("day_" + nextDay(2));
                            JSONObject no3 = future.getJSONObject("day_" + nextDay(3));
                            JSONObject no4 = future.getJSONObject("day_" + nextDay(4));
                            JSONObject no5 = future.getJSONObject("day_" + nextDay(5));
                            JSONObject no6 = future.getJSONObject("day_" + nextDay(6));
                            String futureShow = nextDay(1)+"\n"+no1.getString("week") + "," + no1.getString("temperature") + "," + no1.getString("weather") + "," + no1.getString("wind") + "\n" +
                                    nextDay(2)+"\n"+no2.getString("week") + "," + no2.getString("temperature") + "," + no2.getString("weather") + "," + no2.getString("wind") + "\n"+
                                    nextDay(3)+"\n"+ no3.getString("week") + "," + no3.getString("temperature") + "," + no3.getString("weather") + "," + no3.getString("wind") + "\n"+
                                    nextDay(4)+"\n"+ no4.getString("week") + "," + no4.getString("temperature") + "," + no4.getString("weather") + "," + no4.getString("wind") + "\n"+
                                    nextDay(5)+"\n"+no5.getString("week") + "," + no5.getString("temperature") + "," + no5.getString("weather") + "," + no5.getString("wind") + "\n"+
                                    nextDay(6)+"\n"+no6.getString("week") + "," + no6.getString("temperature") + "," + no6.getString("weather") + "," + no6.getString("wind");

                            Message message = Message.obtain();

                            message.obj =todayShow+"//"+futureShow;
                            message.what = 1;
                            handler.sendMessage(message);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    /**
     * 获得未来6天的天气情况
     * @param next
     * @return
     */
    public String nextDay(int next) {
        System.out.println("今天的日期：" + df.format(d));
        System.out.println("五天后的日期：" + df.format(new Date(d.getTime() + next * 24 * 60 * 60 * 1000)));
        return df.format(new Date(d.getTime() + next * 24 * 60 * 60 * 1000));
    }

}
