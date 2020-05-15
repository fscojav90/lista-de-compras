package com.ejemplo.listadecompras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ComprasFragment extends Fragment {

    ListView listViewCompras;
    ArrayList<ListaDeCompra> compras;


    @Override
    public void onResume() {
        super.onResume();
        //recibir array del activity
        compras = getActivity().getIntent().getParcelableArrayListExtra("compras");

        if(compras == null){
            Toast toast1 = Toast.makeText(getContext(), "No hay listas creadas!!", Toast.LENGTH_SHORT);
            toast1.show();

        }else {

            for(int i=0;i<compras.size();i++){
                compras.get(i).setNombre("Lista " + (i + 1));

            }
            //ArrayList<Item> itemList = Item.getItemList(getContext());
            ListaDeComprasAdapter adapter = new ListaDeComprasAdapter(getContext(), compras);
            //ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemList);
            listViewCompras.setAdapter(adapter);



        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compras, null);

        listViewCompras = (ListView)view.findViewById(R.id.listViewcompras);

        listViewCompras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(), "Haz presionado: " + compras.get(position).getNombre(), Toast.LENGTH_SHORT).show();

                getActivity().getIntent().putExtra("id", position);

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();

            }
        });


      //  listViewCompras.setAdapter(new ListaDeComprasAdapter(getContext(), getActivity().getIntent().getExtras("compras"));




        return view;
    }
}
