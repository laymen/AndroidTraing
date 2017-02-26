package com.homework.dday2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.entity.Goods;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class MyAdapter extends BaseAdapter {
    private Context c;
    private List<Goods> list;

    public MyAdapter(Context c, List<Goods> list) {
        this.c = c;
        this.list = list;
    }

    //视图中显示的数据项
    @Override
    public int getCount() {
        return list.size();
    }

    //获取每个数据项
    @Override
    public Goods getItem(int position) {
        return list.get(position);
    }

    //获取每一项的position
    @Override
    public long getItemId(int position) {
        return position;
    }

    //加载数据还是都会调用用此方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(c).inflate(R.layout.activity_adapter, null);

        TextView goodName = (TextView) convertView.findViewById(R.id.gname);
        TextView price = (TextView) convertView.findViewById(R.id.prce);
        ImageView iv = (ImageView) convertView.findViewById(R.id.img);

        Goods g = list.get(position);

        goodName.setText(g.getGname());
        price.setText(g.getPrice() + "");
        iv.setBackgroundResource(g.getIcon());

        return convertView;

    }


}
