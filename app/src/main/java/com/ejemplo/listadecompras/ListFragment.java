package com.ejemplo.listadecompras;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ejemplo.listadecompras.ui.gallery.GalleryFragment;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    ListView listViewMain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);

        listViewMain = (ListView) view.findViewById(R.id.listViewMain);

        //getActivity() recuperar referencia actividad padre -> sustituye contexto de ejecución

        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //aquí codigó del botón

            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Item> itemList = Item.getItemList(getContext());
        ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemList);
        listViewMain.setAdapter(itemAdapter);
    }
}
