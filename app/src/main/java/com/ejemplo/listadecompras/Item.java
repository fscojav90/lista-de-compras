package com.ejemplo.listadecompras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Item {

    long id;
    String nombre;
    int estado;

    public Item() {
    }

    public Item(long id, String nombre, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    private Item(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndex("id"));
        nombre = cursor.getString(cursor.getColumnIndex("nombre"));
        estado = cursor.getInt(cursor.getColumnIndex("estado"));
    }

    public static ArrayList<Item> getItemList(Context context) {
        ArrayList<Item> listItems = new ArrayList<>();
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "ITEMS", new String[]{"id",
                        "nombre", "estado"}, null,
                null,null,null,"nombre", null  );

        while (cursor.moveToNext()) {
            listItems.add(new Item(cursor));
        }

        cursor.close();
        db.close();

        return listItems;
    }

    public static Item getItem(Context context, long id) {
        Item item = null;
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where ="id = " + String.valueOf(id);
        Cursor cursor = db.query(true, "ITEMS", new String[]{"id",
                        "nombre", "estado"}, where,
                null,null,null,"nombre", null  );

        if(cursor.moveToFirst())
            item = new Item(cursor);

        cursor.close();
        db.close();

        return item;
    }

    public void insert(Context context) {
        ContentValues values = new ContentValues();
        values.put("nombre",this.nombre);
        values.put("estado",this.estado);

        LocalSQLiteOpenHelper helper = new LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        this.id=db.insert("ITEMS", null, values);
        db.close();
    }

    public void update(Context context) {
        ContentValues values = new ContentValues();
        values.put("nombre",this.nombre);
        values.put("estado",this.estado);

        String whereClause = "id=" + String.valueOf(this.id);
        LocalSQLiteOpenHelper helper = new LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.update("ITEMS", values,whereClause,null);
        db.close();
    }

    public void delete(Context context) {
        String whereClause = "id= ?" ;
        String[] whereArgs = new String[1];
        whereArgs[0] = String.valueOf(this.id);
        LocalSQLiteOpenHelper helper = new LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("ITEMS", whereClause,whereArgs);
        db.close();
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
