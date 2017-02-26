package com.mouse.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mouse on 2017/2/21.
 */
public class SecondActivity extends AppCompatActivity {
    private ListView lv;
    private SimpleAdapter adapter;//适配器
    private List<Map<String,Object>>list;//数据源
    int[] images={R.drawable.a289,R.drawable.a290,R.drawable.a293,R.drawable.a300,R.drawable.a301,R.drawable.a309,
            R.drawable.a320,R.drawable.a323,R.drawable.a324,R.drawable.a329,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        lv=(ListView)findViewById(R.id.lv);
        list=new ArrayList<>();

        for (int i=0;i<images.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",images[i]+"");
            map.put("sell","售卖"+i);
            list.add(map);
        }
        adapter=new SimpleAdapter(this,list,R.layout.second_simple,new String[]{"image","sell"},new int[]{R.id.img, R.id.kind});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplication(),ThridActivty.class);
                startActivity(intent);
            }
        });

    }
}
