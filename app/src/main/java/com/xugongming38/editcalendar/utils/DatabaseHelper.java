package com.xugongming38.editcalendar.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 2017/5/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_DIARY = "create table Hair("
            + "id integer primary key autoincrement, "
            + "content text)";

    private Context mContext;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Hair");
        onCreate(db);
    }
}
