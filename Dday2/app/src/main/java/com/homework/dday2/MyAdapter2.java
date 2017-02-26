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
public class MyAdapter2 extends BaseAdapter {
    private Context c;
    private List<Goods>list;

    public MyAdapter2(Context c, List<Goods> list) {
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
        ViewHolder holder= new ViewHolder();

        if (convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.activity_adapter,null);

            holder.gname= (TextView) convertView.findViewById(R.id.gname);
            holder.price=(TextView) convertView.findViewById(R.id.prce);
            holder.iv=(ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();

        }


        Goods g=list.get(position);

        holder.gname.setText(g.getGname());
        holder.price.setText(g.getPrice()+"");
        holder.iv.setBackgroundResource(g.getIcon());




        return convertView;

    }

    public  class ViewHolder{
        public  TextView gname;
        public  TextView price;
        public  ImageView iv;
    }
}
