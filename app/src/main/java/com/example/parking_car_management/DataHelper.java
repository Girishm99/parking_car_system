package com.example.parking_car_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="carparking.db";


    public static final String TABLE_NAME ="user";
    public static final String COL_ID ="ID";
    public static final String COL_NAME ="NAME";
    public static final String COL_EMAIL ="EMAIL";
    public static final String COL_Car_Number ="Car_number";


    public static final String TABLE_FEEDBACK="admin";
    public static final String COL_FEEDBACK ="Feedback";


    public static final String TABLE_SLOTDETAILS="Slot";
    public static final String COL_SLOTID ="SlotID";
    public static final String COL_SLOATNAME ="NAME";
    public static final String COL_SLOTADDRESS ="ADDRESS";
    public static final String COL_NORMALID ="ID";


    public DataHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }


    public static final String userdetails="create table "+TABLE_NAME+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,Car_number INTEGER)";
    public static final String adminfeedback="create table "+TABLE_FEEDBACK+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT,Feedback TEXT)";
    public static final String slotdetails="create table "+TABLE_SLOTDETAILS+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SLOTID INTEGER,ADDRESS TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(userdetails);
        db.execSQL(adminfeedback);
        db.execSQL(slotdetails);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FEEDBACK);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SLOTDETAILS);
        onCreate(db);

    }

    public boolean insertdata(String name,String email,String carnumber){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_EMAIL,email);
        values.put(COL_Car_Number,carnumber);
        long result= db.insert(TABLE_NAME,null,values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertfeedback(String feedback){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_FEEDBACK,feedback);
        long result= db.insert(TABLE_FEEDBACK,null,values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertslot(String name,String address,String slotid){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_SLOATNAME,name);
        values.put(COL_SLOTADDRESS,address);
        values.put(COL_SLOTID,slotid);

        long result= db.insert(TABLE_SLOTDETAILS,null,values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Cursor getAlldataadmin(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_FEEDBACK,null);
        return res;
    }
    public Cursor getAlldataslot(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_SLOTDETAILS,null);
        return res;
    }

    public  boolean updatedata(String name,String id,String email,String carnumber){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_ID,id);
        values.put(COL_NAME,name);
        values.put(COL_EMAIL,email);
        values.put(COL_Car_Number,carnumber);
        db.update(TABLE_NAME,values,"ID = ?",new  String[] {id});
        return true;
    }

    public Integer deletedata(String id) {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});
    }

    public Integer deletedataadmin(String id) {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_FEEDBACK,"ID = ?",new String[] {id});
    }
}
