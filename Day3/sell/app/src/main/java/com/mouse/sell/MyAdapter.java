package com.mouse.sell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class MyAdapter extends BaseAdapter {
    private Context c;
    private List<Good>list;
    private GoodDao dao;

    public MyAdapter(Context c, List<Good> list,GoodDao dao) {
        this.c = c;
        this.list = list;
        this.dao = dao;
    }

    //视图中显示的数据项
    @Override
    public int getCount() {
        return list.size();
    }
    //获取每个数据项
    @Override
    public Good getItem(int position) {
        return list.get(position);
    }
    //获取每一项的position
    @Override
    public long getItemId(int position) {
        return position;
    }
    //加载数据还是都会调用用此方法
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder= new ViewHolder();

        if (convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.adapter,null);

            holder.gname= (TextView) convertView.findViewById(R.id.gname);
            holder.gprice= (TextView) convertView.findViewById(R.id.gprice);
            holder.Layout=(LinearLayout)convertView.findViewById(R.id.Layout);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();

        }


        Good g=list.get(position);

        holder.gname.setText(g.getGname());
        holder.gprice.setText(g.getGprice() + "");


        return convertView;

    }



    public  class ViewHolder{
        public  TextView gname;
        public  TextView gprice;
        public LinearLayout Layout;
    }
}
