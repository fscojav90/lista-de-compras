package com.ejemplo.listadecompras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddItemFragment extends Fragment {

    Button buttonAddItem;
    LinearLayout addItemLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additem, null);


        buttonAddItem = (Button)view.findViewById(R.id.buttonAddItem);

        EditText editText = new EditText(getContext());
        addItemLayout = (LinearLayout)view.findViewById(R.id.add_itemLayout);


        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem() ;
            }
        });



        //getActivity() recuperar referencia actividad padre -> sustituye contexto de ejecución

                //aquí codigó del botón


        return view;
    }

    private void addItem() {
        EditText editNewActor = new EditText(getContext());
        addItemLayout.addView(editNewActor);
    }


    @Override
    public void onResume() {
        super.onResume();
//        ArrayList<Item> itemList = Item.getItemList(getContext());
//        ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemList);
    }
}
