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
    int fk_lista;

    public Item() {
    }

    public Item(long id, String nombre, int estado, int fk_lista) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fk_lista = fk_lista;
    }

    private Item(Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndex("id"));
        nombre = cursor.getString(cursor.getColumnIndex("nombre"));
        estado = cursor.getInt(cursor.getColumnIndex("estado"));
        fk_lista = cursor.getInt(cursor.getColumnIndex("fk_lista"));

    }

    public static ArrayList<Item> getItemList(Context context) {
        ArrayList<Item> listItems = new ArrayList<>();
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "ITEMS", new String[]{"id",
                        "nombre", "estado", "fk_lista"}, null,
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
                        "nombre", "estado", "fk_lista"}, where,
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
        values.put("fk_lista",this.fk_lista);

        LocalSQLiteOpenHelper helper = new LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        this.id=db.insert("ITEMS", null, values);
        db.close();
    }

    public void update(Context context) {
        ContentValues values = new ContentValues();
        values.put("nombre",this.nombre);
        values.put("estado",this.estado);
        values.put("fk_lista",this.fk_lista);

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
