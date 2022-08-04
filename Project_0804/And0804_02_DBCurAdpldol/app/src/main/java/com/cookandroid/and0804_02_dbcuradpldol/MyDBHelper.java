package com.cookandroid.and0804_02_dbcuradpldol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "groupDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE contactTBL(_id integer PRIMARY KEY autoincrement, name text, count text);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists contacttbl;"); // 테이블 삭제
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contactDB");
        onCreate(sqLiteDatabase);
    }
}
