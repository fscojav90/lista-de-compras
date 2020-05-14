package com.ejemplo.listadecompras;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    Context context;

    public ItemAdapter(Context context, List<Item> objects) {
        super(context, -1, objects);
        this.context = context;
    }

    @Override
    public long getItemId(int pos) {
        return getItem(pos).id;
    }


    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
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

        Item item = getItem(pos);

        TextView nombre =(TextView)view.findViewById(R.id.textViewNombre);
        CheckBox estado =(CheckBox) view.findViewById(R.id.checkBoxEstado);
        nombre.setText(item.getNombre());


        if(item.getEstado() == 1){
            estado.setChecked(true);
        }else{
            estado.setChecked(false);
        }

        return view;
    }
}

