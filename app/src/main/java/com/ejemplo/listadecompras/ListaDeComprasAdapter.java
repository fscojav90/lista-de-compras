package com.ejemplo.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ListaDeComprasAdapter extends ArrayAdapter<ListaDeCompra> {

    Context context;

    public ListaDeComprasAdapter(Context context, List<ListaDeCompra> compras) {
        super(context, -1, compras);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_lista, null);

            //LayoutInflater layoutInflater = (LayoutInflater)
            //  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //view = layoutInflater.inflate(R.layout.list_item, parent);
        } else {
            view = convertView;
        }

        ListaDeCompra listaDeCompra = getItem(position);

        TextView nombre =(TextView)view.findViewById(R.id.textViewNombreLista);
        nombre.setText(listaDeCompra.getNombre());

        return view;

    }
}
