package com.homework.dday3;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 将字符串进行保存
 * 保存int
 * 保存double
 * <p/>
 * 获取字符串
 * 获取int
 * 获取double
 * Created by Administrator on 2017/2/22 0022.
 */
public class SharedPreferencesUtils {
    public static SharedPreferences preferences; //共享
    public static String fileName = "app";

    /**
     * 保存
     *
     * @param c
     * @param key
     * @param value
     */
    public static void putString(Context c, String key, String value) {
        if (preferences == null) {//不存在就创建
            preferences = c.getSharedPreferences(fileName, c.MODE_WORLD_READABLE);
        }
        SharedPreferences.Editor editor = preferences.edit().putString(key, value);
        editor.commit();
    }

    /**
     * 读取
     * @param c
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Context c, String key,String defaultValue) {
        if (preferences == null) {
            preferences = c.getSharedPreferences(fileName, c.MODE_WORLD_READABLE);
        }
        return preferences.getString(key, defaultValue);
    }

    /**
     * 移除
     *
     * @param c
     * @param key
     */
    public static void remove(Context c, String key) {
        if (preferences == null) {
            preferences = c.getSharedPreferences(fileName, c.MODE_WORLD_READABLE);
        }
        SharedPreferences.Editor editor = preferences.edit().remove(key);
        editor.commit();
    }

//    /**
//     * 保存数据
//     *
//     * @param context
//     * @param fileName
//     * @param saveKey
//     * @param saveValue int double 都可以变成String
//     */
//    public static void save(Context context, String fileName, String saveKey, String saveValue) {
//        SharedPreferences preferences = context.getSharedPreferences(fileName, context.MODE_WORLD_READABLE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString(saveKey, saveValue); //key-value
//        editor.commit();
//    }
//
//    /**
//     * 取出数据
//     *
//     * @param context
//     * @param fileName
//     * @return
//     */
//    public static String read(Context context, String fileName, String readKey) {
//        SharedPreferences preference = context.getSharedPreferences(fileName, context.MODE_WORLD_READABLE);
//
//        String data = preference.getString(readKey, "").toString();
//
//        return data;
//    }


}
