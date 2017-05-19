package com.xugongming38.editcalendar.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/5/18.
 */

public class DataHelper {
    public static DatabaseHelper mHelper;
    public static void deleteData2List(String content) {
        SQLiteDatabase dbDelete = mHelper.getWritableDatabase();
        dbDelete.delete("Hair", "content = ?", new String[]{content});

    }
    public static void addData2List(String content) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("content", content);
        db.insert("Hair", null, values);
        values.clear();
    }
    public static List<String> getDataList(Context context) {

        if(mHelper==null){
            mHelper = new DatabaseHelper(context, "Hair.db", null, 1);
        }
        List<String> dataList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = mHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("Hair", null, null, null, null, null, null);


        if (cursor.moveToFirst()) {
            do {
                String content = cursor.getString(cursor.getColumnIndex("content"));
                dataList.add(content);
            } while (cursor.moveToNext());
        }
        cursor.close();


        return dataList;
    }
}
