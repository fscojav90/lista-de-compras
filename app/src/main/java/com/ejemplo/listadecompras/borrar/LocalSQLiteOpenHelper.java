package com.ejemplo.listadecompras.borrar;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LocalSQLiteOpenHelper extends SQLiteOpenHelper {

    static String DB_NAME = "listaDeCompras";
    static int DB_VERSION = 1;

    public LocalSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query ="CREATE TABLE ITEMS(id INTEGER PRIMARY KEY," +
                "nombre TEXT, estado INTEGER, fk_lista INTEGER);";
        db.execSQL(query);
    }

    public static void deleteDatabase(Context mContext) {
        mContext.deleteDatabase(DB_NAME);
    }

    public void clearDB()
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            db.delete(DB_NAME, null, null);

            db.close(); // Closing database connection
        } catch (SQLiteException ex) {
        }
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
