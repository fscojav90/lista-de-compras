package com.ejemplo.listadecompras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MyListFragment extends Fragment {

    Button buttonLista1;
    Button buttonLista2;
    Button buttonLista3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mylist, null);
        buttonLista1 = (Button) view.findViewById(R.id.buttonLista1);
        buttonLista2 = (Button) view.findViewById(R.id.buttonLista2);
        buttonLista3 = (Button) view.findViewById(R.id.buttonLista3);

        buttonLista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new AddItemFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();


            }
        });

        buttonLista2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea el nuevo fragmento y la transacción.
                Fragment nuevoFragmento = new ListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nuevoFragmento);
                transaction.addToBackStack(null);

                // Commit a la transacción
                transaction.commit();





            }
        });







        return view;
    }
}
