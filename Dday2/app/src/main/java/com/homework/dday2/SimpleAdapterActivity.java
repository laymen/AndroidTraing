package com.homework.dday2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class SimpleAdapterActivity extends Activity {
    private ListView lv;//
    private SimpleAdapter adapter;//适配器
    private List<Map<String, Object>> list;//数据源
    int[] images = {R.drawable.music, R.drawable.note, R.drawable.contacts, R.drawable.store};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", images[i] + "");
            map.put("text", "文本内容");
            list.add(map);
        }
        adapter = new SimpleAdapter(this, list, R.layout.activity_simple, new String[]{"image", "text"}, new int[]{R.id.img, R.id.txt});
        lv.setAdapter(adapter);
    }
}
