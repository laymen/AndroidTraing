package com.mouse.sell;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class GoodDao {
    public MyHelper helper;
    public SQLiteDatabase db;

    public GoodDao(Context c) {
        helper = new MyHelper(c);
    }

    /**
     * 初始化链接对象
     */
    private void getDB() {
        db = helper.getWritableDatabase();

    }

    public void addGood(Good g) {
        getDB();
        db.execSQL("insert into good(gname,gprice) values(?,?)", new Object[]{g.getGname(), g.getGprice()});
    }


    public void deleteFood(int id) {
        getDB();
        //delect from user where uid=?
        db.delete("good", "uid=?", new String[]{id + ""});
        db.close();
    }

    public Good showGood(int uid) {
        getDB();
        Cursor c = db.query("good", null, "uid=" + uid, null, null, null, null);
        Good g = new Good();
        if (c.moveToFirst()) {
            g.setUid(c.getInt(0));
            g.setGname(c.getString(1));
            g.setGprice(c.getInt(2));
        }
        c.close();
        return g;

    }

    public List<Good> showAllGoods() {
        getDB();
        //select *  from user;
        Cursor c = db.query("good",null,null,null,null,null,null);
        List<Good> gs = new ArrayList<>();
        while (c.moveToNext()) {
            Good g = new Good();
            g.setUid(c.getInt(0));
            g.setGname(c.getString(1));
            g.setGprice(c.getInt(2));
            gs.add(g);
        }
        c.close();//关闭游标
        return gs;

    }
}
