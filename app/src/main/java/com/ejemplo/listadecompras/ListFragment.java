package com.ejemplo.listadecompras;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ejemplo.listadecompras.ui.gallery.GalleryFragment;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    ArrayList<ListaDeCompra> compras;

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
                startViewDVDActivity(id);

            }
        });

        return view;
    }

    private void startViewDVDActivity(long dvdId) {
       // Intent intent = new Intent(getActivity(),
        //        ViewDVDActivity.class);
       // intent.putExtra("dvdId",dvdId);
       // startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();
        compras = getActivity().getIntent().getParcelableArrayListExtra("compras");
        int id = getActivity().getIntent().getIntExtra("id", 0);

        if(compras == null){
            Toast toast1 = Toast.makeText(getContext(), "No hay listas creadas!!", Toast.LENGTH_SHORT);
            toast1.show();

        }else {

            for(int i=0;i<compras.size();i++){
                compras.get(i).setNombre("Lista " + (i + 1));

            }
            //ArrayList<Item> itemList = Item.getItemList(getContext());
            ProductoAdapter adapter = new ProductoAdapter(getContext(), compras.get(id).getProductos());
            //ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemList);
            listViewMain.setAdapter(adapter);

        }


        getActivity().getIntent().getIntExtra("id", 0);



    }
}
