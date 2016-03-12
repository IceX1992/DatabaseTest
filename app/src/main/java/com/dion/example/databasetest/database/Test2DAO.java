package com.dion.example.databasetest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dion.example.databasetest.entity.testEntity;
import com.dion.example.databasetest.entity.ziekteEntity;

/**
 * Created by Dion on 3/11/2016.
 */
public class Test2DAO extends SQLiteOpenHelper{

    public static final String TEST_TABLE = "voorbeeld";
    public static final String TEST_ID = "id";
    public static final String TEST_USERNAME = "usrnam";
    public static final String TEST_PASSWORD="pw";
    public static final String TEST_VOORNAAM = "voornaam";
    public static final String TEST_GEBOORTE = "geboortejaar";

    public static final String REAL_TABLE = "ziekte";
    public static final String REAL_ID = "id";
    public static final String REAL_NAAM = "naam";
    public static final String REAL_ONTDEKT = "ontdekt door";
    public static final String REAL_JAARVANONTDEKKING = "ontdekt in";

    private static final String DB_TEST = "test.db";
    private static final int TEST_VERSION = 1;

    private static final String SQL_PB_TABLE_QUERY = "create table voorbeeld(id INTEGER PRIMARY KEY,usrnam TEXT,pw TEXT, voornaam TEXT,geboortejaar TEXT);";
    private static final String SQL_REAL_TABLE_QUERY = "create table ziekte(id INTEGER PRIMARY KEY, naam TEXT,ontdekt_door TEXT, ontdekt_in TEXT);";

    public Test2DAO(Context context) {
        super(context, DB_TEST, null, TEST_VERSION);
        insertDefault();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PB_TABLE_QUERY);
        db.execSQL(SQL_REAL_TABLE_QUERY);
     //   insertData(db, "eci", "bye");
        //   insertData(db, "fire", "hello");
     //   insertData(db, "wind", "stay");

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
        testValues.put(TEST_VOORNAAM, "dion");
        testValues.put(TEST_GEBOORTE, "03-12-1992");
        insertValue(TEST_TABLE, testValues);

        ContentValues testValues2 = new ContentValues();
        testValues2.put(TEST_USERNAME, "fire");
        testValues2.put(TEST_PASSWORD, "hello");
        testValues2.put(TEST_VOORNAAM, "Laks");
        testValues2.put(TEST_GEBOORTE, "20-02-1995");
        insertValue(TEST_TABLE, testValues2);

        ContentValues testValues3 = new ContentValues();
        testValues3.put(TEST_USERNAME, "wind");
        testValues3.put(TEST_PASSWORD, "stay");
        testValues3.put(TEST_VOORNAAM, "Reks");
        testValues3.put(TEST_GEBOORTE, "13-01-1995");
        insertValue(TEST_TABLE, testValues3);


        ContentValues testValues4 = new ContentValues();
        testValues4.put(REAL_NAAM, "griep");
        testValues4.put(REAL_ONTDEKT, "dion");
        testValues4.put(REAL_JAARVANONTDEKKING, "10-10-1910");
        insertValue(REAL_TABLE, testValues4);

        ContentValues testValues5 = new ContentValues();
        testValues5.put(REAL_NAAM, "koorts");
        testValues5.put(REAL_ONTDEKT, "Retels");
        testValues5.put(REAL_JAARVANONTDEKKING, "20-11-1920");
        insertValue(REAL_TABLE, testValues5);

    }

    public  long insertValue( String tableName, ContentValues test){
        SQLiteDatabase db = getWritableDatabase();
        long rowId = db.insert(tableName, null, test);
        db.close();
        //return the row ID of the newly inserted row, or -1 if an error occurred
        return rowId;
    }

    public testEntity login(String username, String password) {
        testEntity test = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s' AND %s = '%s';", TEST_TABLE, TEST_USERNAME, username, TEST_PASSWORD, password);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            test = new testEntity(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        }
        db.close();
        return test;
    }

    public ziekteEntity showZiekte(String ontdekker) {
        ziekteEntity test = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s';", REAL_TABLE, REAL_ONTDEKT, ontdekker);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            test = new ziekteEntity(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        db.close();
        return test;
    }

    public ziekteEntity showZiekteByVoornaam(String ontdekker) {
        ziekteEntity test = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s';", REAL_TABLE, REAL_ONTDEKT, ontdekker);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()) {
            test = new ziekteEntity(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        db.close();
        return test;
    }
/*

    public testEntity findpw (String usrnam){
        testEntity test = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s';", TEST_TABLE, TEST_USERNAME, usrnam);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()){
            test = new testEntity(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        }
        db.close();
        return test;
    }
*/

    /*
    public ziekteEntity findZiekte(String ziekteNaam){
        ziekteEntity test1 = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s where %s = '%s';", REAL_TABLE, REAL_ONTDEKT, ziekteNaam);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext()){
            test1 = new ziekteEntity(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        db.close();
        return test1;
    }

*/
}
