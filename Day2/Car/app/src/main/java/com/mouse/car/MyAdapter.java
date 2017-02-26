package com.mouse.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
public class MyAdapter extends BaseAdapter {
    private Context c;
    private List<Car>list;

    public MyAdapter(Context c, List<Car> list) {
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
    public Car getItem(int position) {
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
            convertView= LayoutInflater.from(c).inflate(R.layout.third_adapter,null);

            holder.cname= (TextView) convertView.findViewById(R.id.kind);
            holder.iv=(ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();

        }


        Car car=list.get(position);

        holder.cname.setText(car.getCarname());
        holder.iv.setBackgroundResource(car.getIncon());

        return convertView;

    }

    public  class ViewHolder{
        public  TextView cname;
        public  ImageView iv;
    }
}
