package com.example.sqliteassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table Userinfo(number INTEGER primary key,name TEXT,age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists Userinfo");
    }

    public Boolean insertuserdata(int number, String name, int age) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("number", number);
        cv.put("name", name);
        cv.put("age", age);
        long result = DB.insert("Userinfo", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateuserdata(int number, String name, int age) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("age", age);

        Cursor cursor = DB.rawQuery("Select * from Userinfo where number=?", new String[]{String.valueOf(number)});
        if (cursor.getCount() > 0) {


            long result = DB.update("Userinfo", cv, "number=?", new String[]{String.valueOf(number)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(int number) {
        SQLiteDatabase DB = this.getWritableDatabase();


        Cursor cursor = DB.rawQuery("Select * from Userinfo where number=?", new String[]{String.valueOf(number)});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userinfo", "number=?", new String[]{String.valueOf(number)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userinfo", null);
        return cursor;
    }

    public Cursor display(int numberCheck) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cr = DB.rawQuery("select * from Userinfo where number = " + numberCheck, null);
        return cr;
    }


}
