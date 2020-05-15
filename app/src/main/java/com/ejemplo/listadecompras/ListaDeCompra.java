package com.ejemplo.listadecompras;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class ListaDeCompra implements Parcelable {
    String nombre;
    ArrayList<Producto> productos;

    public ListaDeCompra() {

        productos = new ArrayList<>();
    }

    public ListaDeCompra(String nombre, ArrayList<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    protected ListaDeCompra(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<ListaDeCompra> CREATOR = new Creator<ListaDeCompra>() {
        @Override
        public ListaDeCompra createFromParcel(Parcel in) {
            return new ListaDeCompra(in);
        }

        @Override
        public ListaDeCompra[] newArray(int size) {
            return new ListaDeCompra[size];
        }
    };

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);


    }
}

