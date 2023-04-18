package com.example.agedatabase.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {
    private static final String TABLE_N_AND_A = "name_and_adresses";
    private SQLiteDatabase mDB;


    public static String TABLE_ID = "_id";
    public static String TABLE_NAME = "name";
    public static String TABLE_AGE = "age";


    static final String DB_NAME = "address_book_db";
    static final int DB_VERSION = 1;
    static final String TABLE_N_AND_A_ = "names_and_addresses";

    public DataManager(Context context) {

        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        mDB = helper.getWritableDatabase();
    }

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        // Get all the records
        public Cursor selectAll() {
            Cursor c = mDB.rawQuery("SELECT *" + " from " +
                    TABLE_N_AND_A, null);
            return c;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
// Add all the details to the table
            String newTableQueryString = "CREATE TABLE "
                    + TABLE_N_AND_A_ + " ("
                    + TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + TABLE_NAME + " TEXT NOT NULL, "
                    + TABLE_AGE + "TEXT NOT NULL);";
            db.execSQL(newTableQueryString);
        }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


    public Cursor searchName(String name) {
        String query = "SELECT *" + " from " + TABLE_N_AND_A + " WHERE " + TABLE_NAME + " = '" + name + "';";
                Log.i("searchName() = ", query);
        Cursor c = mDB.rawQuery(query, null);
        return c;
    }

    public void onUpgrade(SQLiteDatabase db) {


    }

    public void insert(String name, String age) {

// Add all the details to the table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_NAME + ", " +
                TABLE_AGE +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + age + "'" +
                ");";
        Log.i("insert() = ", query);
        mDB.execSQL(query);

    }

    public void delete(String name) {

// Remove all the details to the table
        String query = "DELETE FROM " + TABLE_N_AND_A + " WHERE " +
                TABLE_NAME + " = '" + name + "';";
        Log.i("delete() = ", query);
        mDB.execSQL(query);




        }
    }

