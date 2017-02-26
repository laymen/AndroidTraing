package com.homework.dday2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.视图：初始化视图
 * 2.初始化数据源
 * 3.初始化适配器
 * 1.ArrayAdapter ：new ArrayAdapter(context, 布局文件，数据源)
 * new ArrayAdapter(context,自定义布局文件，布局文件中的TextView的ID，数据源)
 * 2.simpleAdapter:new SimpleAdapter(context,数据源，布局文件，new String[]{key1,key2,key3....},new String[]{value1,value2,value3....})
 * 3.自定义适配器：
 * 1.创建一个继承BaseAdapter
 * 2.重写四个方法
 * getCount:显示有多少项
 * GetItem:返回某一个数据项
 * GetItemId:返回某一数据项的id
 * getView（）：显示某一项的布局，每次加载都会调用getView方法
 * 动态加载布局，然后初始化布局空间--给控件赋值（从数据源中取数据）
 * 4.绑定适配器，通过setAdapter进行绑定
 * 5.设置监听事件
 * <p>
 * <p>
 * <p>
 * Created by Administrator on 2017/2/21 0021.
 */
public class CustomActivty extends Activity {
    private ListView lv;
    private List<Goods> data;
    private MyAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        //初始化ListView对象
        lv = (ListView) findViewById(R.id.lv);
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Goods goods = new Goods();
            goods.setGname("商品名" + i);
            goods.setPrice(500 + i);
            goods.setIcon(R.drawable.note);
            data.add(goods);
        }
        adapter = new MyAdapter2(this, data);
        lv.setAdapter(adapter);

//Listview的滚动监听原理
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 6) {

                } else {

                }

            }
        });
    }
}
