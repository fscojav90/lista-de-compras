package com.ejemplo.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {

    Context context;


    public ProductoAdapter(Context context, List<Producto> productos) {
        super(context, -1, productos);
        this.context = context;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);

            //LayoutInflater layoutInflater = (LayoutInflater)
            //  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //view = layoutInflater.inflate(R.layout.list_item, parent);
        } else {
            view = convertView;
        }

        final Producto producto = getItem(pos);

        TextView nombre =(TextView)view.findViewById(R.id.textViewNombre);
        CheckBox estado =(CheckBox) view.findViewById(R.id.checkBoxEstado);
        nombre.setText(producto.getNombre());

        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                producto.setEstado(!producto.isEstado());
                Toast.makeText(getContext(), "presionado: " + pos, Toast.LENGTH_SHORT).show();

            }
        });


        if(producto.isEstado()){
            estado.setChecked(true);
        }else{
            estado.setChecked(false);
        }

        return view;
    }


}
