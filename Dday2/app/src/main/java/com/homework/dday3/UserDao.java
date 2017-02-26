package com.homework.dday3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class UserDao {
    public MyHelper helper;
    public SQLiteDatabase db;

    public UserDao(Context c) {
        helper = new MyHelper(c);
    }

    /**
     * 初始化链接对象
     */
    private void getDB() {
        db = helper.getWritableDatabase();

      //  db=SQLiteDatabase.openDatabase("path",null,SQLiteDatabase.OPEN_READONLY);//引用的外部的数据库，就引用

    }

    public void addUser(User u) {
        getDB();
        //一种
//        db.execSQL("insert into user(uname,uage) values("+u.getName()+","+u.getAge()+")");
        //二种
        db.execSQL("insert into user(uname,uage) values(?,?)", new Object[]{u.getName(), u.getAge()});
        //三种
//        ContentValues values=new ContentValues();
//        values.put("uname",u.getName());
//        values.put("uage",u.getAge());
//        db.insert("user",null,values);
    }

    public void updateUser(User u) {
        getDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uname", u.getName());
        contentValues.put("uage", u.getAge());
        //db.update("user",)


    }

    public void delete(int id) {
        getDB();
        //delect from user where uid=?
        db.delete("user", "uid=?", new String[]{id + ""});
        db.close();
    }

    public User showUser(int uid) {
        getDB();
        Cursor c = db.query("user", null, "uid=" + uid, null, null, null, null);
        User u = new User();
        if (c.moveToFirst()) {
            u.setUid(c.getInt(0));
            u.setName(c.getString(1));
            u.setAge(c.getInt(2));
        }
        c.close();
        return u;

    }

    public List<User> showAllUser() {
        getDB();
        //select *  from user;
        Cursor c = db.query("user",null,null,null,null,null,null);
        List<User> users = new ArrayList<>();
        while (c.moveToNext()) {
            User u = new User();
            u.setUid(c.getInt(0));
            u.setName(c.getString(1));
            u.setAge(c.getInt(2));
            users.add(u);
        }
        c.close();//关闭游标
        return users;

    }
}
