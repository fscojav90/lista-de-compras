package com.ejemplo.listadecompras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
                "nombre TEXT, estado INTEGER);";
        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
