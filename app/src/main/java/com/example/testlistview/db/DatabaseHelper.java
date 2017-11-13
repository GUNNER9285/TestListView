package com.example.testlistview.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testlistview.R;

/**
 * Created by GUNNER on 5/11/2560.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "animal.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "animal";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_PICTURE = "picture";
    public static final String COL_DEATIL = "detail";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
                                                +COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                +COL_NAME+" TEXT, "
                                                +COL_PICTURE+" TEXT, "
                                                +COL_DEATIL+" TEXT"
                                                +")";

    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        insertInitialData(db);
    }
    private void insertInitialData(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "แมว (Cat)");
        cv.put(COL_PICTURE, "animals_cat.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_cat));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "หมา (Dog)");
        cv.put(COL_PICTURE, "animals_dog.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_dog));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "โลมา (Dolphin)");
        cv.put(COL_PICTURE, "animals_dolphin.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_dolphin));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "โคอาลา (Koala)");
        cv.put(COL_PICTURE, "animals_koala.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_koala));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "สิงโต (Lion)");
        cv.put(COL_PICTURE, "animals_lion.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_lion));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "นกฮูก (Owl)");
        cv.put(COL_PICTURE, "animals_owl.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_owl));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เพนกวิน (Penguin)");
        cv.put(COL_PICTURE, "animals_penguin.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_dolphin));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "กระต่าย (Rabbit)");
        cv.put(COL_PICTURE, "animals_rabbit.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_rabbit));
        db.insert(TABLE_NAME,null,cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "เสือ (Tiger)");
        cv.put(COL_PICTURE, "animals_tiger.png");
        cv.put(COL_DEATIL, mContext.getString(R.string.details_tiger));
        db.insert(TABLE_NAME,null,cv);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // code for upgrading the database
    }
}
