package com.example.myapplicationbigtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

 public static final String DBNAME="login.db";

    public DBHelper(Context context) {

        super(context,"login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MYDB) {
      MYDB.execSQL("create table users(username TEXT primary key , password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MYDB, int i, int i1) {
     MYDB.execSQL("drop Table if exists users");
    }
    public boolean insertdata(String username,String password){
        SQLiteDatabase MYBD=this.getWritableDatabase();
        ContentValues contentvalues =new ContentValues();
        contentvalues.put("username",username);
        contentvalues.put("password",password);
        Long result=MYBD.insert("users",null,contentvalues);
        if (result==-1)return false;
        else
          return true;


    }
    public boolean checkusername(String username){
        SQLiteDatabase MYDB=this.getWritableDatabase();
        Cursor cursor=MYDB.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkuserpassword(String username,String password){
        SQLiteDatabase MYDB=this.getWritableDatabase();
        Cursor cursor = MYDB.rawQuery("select * from users where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;





    }

}
