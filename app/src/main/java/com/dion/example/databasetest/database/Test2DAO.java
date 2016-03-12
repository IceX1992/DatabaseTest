package com.dion.example.databasetest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dion.example.databasetest.entity.testEntity;

/**
 * Created by Dion on 3/11/2016.
 */
public class Test2DAO extends SQLiteOpenHelper{

    private static final String DB_TEST = "test.db";
    private static final int TEST_VERSION = 1;

    public static final String TEST_TABLE = "voorbeeld";
    public static final String TEST_ID = "id";
    public static final String TEST_USERNAME = "usrnam";
    public static final String TEST_PASSWORD="pw";

    private static final String SQL_PB_TABLE_QUERY = "create table voorbeeld(id INTEGER PRIMARY KEY,usrnam TEXT,pw TEXT);";


    public Test2DAO(Context context) {
        super(context, DB_TEST, null, TEST_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PB_TABLE_QUERY);
     //   insertData(db, "eci", "bye");
     //  insertData(db, "fire", "hello");
     //   insertData(db, "wind", "stay");
        insertDefault();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
/*
    public static void insertData (SQLiteDatabase db, String usrnam, String pw){
        ContentValues test = new ContentValues();
        test.put(TEST_USERNAME, usrnam);
        test.put(TEST_PASSWORD,pw);
        db.insert(TEST_TABLE,null,test);
    }

*/
    private void insertDefault (){

        ContentValues testValues = new ContentValues();
        testValues.put(TEST_USERNAME, "ice");
        testValues.put(TEST_PASSWORD, "bye");
        insertValue(TEST_TABLE, testValues);

        ContentValues testValues2 = new ContentValues();
        testValues2.put(TEST_USERNAME, "fire");
        testValues2.put(TEST_PASSWORD, "hello");
        insertValue(TEST_TABLE, testValues2);

        ContentValues testValues3 = new ContentValues();
        testValues3.put(TEST_USERNAME, "wind");
        testValues3.put(TEST_PASSWORD, "stay");
        insertValue(TEST_TABLE, testValues3);
    }

    public  long insertValue( String tableName, ContentValues test){
        SQLiteDatabase db = getWritableDatabase();
        long rowId = db.insert(tableName, null, test);
        db.close();
        //return the row ID of the newly inserted row, or -1 if an error occurred
        return rowId;
    }


    public testEntity findpw (String usrnam){
        testEntity test = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s';", TEST_TABLE, TEST_USERNAME ,usrnam);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()){
            test = new testEntity(cursor.getLong(0),cursor.getString(1), cursor.getString(2));
        }
        db.close();
        return test;
    }

}
