package com.entity;

import android.graphics.drawable.Drawable;

/**
 * 商品类
 * Created by Administrator on 2017/2/21 0021.
 */
public class Goods {
    private  String gname;
    private  double price;
    private int icon;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
