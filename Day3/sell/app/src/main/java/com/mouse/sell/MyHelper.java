package com.mouse.sell;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class MyHelper extends SQLiteOpenHelper {
    private static String fileName = "db.db";

    public MyHelper(Context context) {
        super(context, fileName, null, 1);
    }

    /**
     * 当数据中没有此表的时候进行调用
     *
     * @param db
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table good(uid integer primary key autoincrement,gname varchar(20),gprice int)");

    }

    /**
     * 版本号发现变化时调用
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
