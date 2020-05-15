package com.ejemplo.listadecompras;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddItemFragment extends Fragment {
  //  ArrayList<ListaDeCompra> compras;

    Button buttonAddItem;
    Button buttonAddItemGuardar;

    LinearLayout addItemLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    compras = new ArrayList<>();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        String[] items = new
                String[addItemLayout.getChildCount()];
        for(int i=0;i<addItemLayout.getChildCount();i++) {
            View child = addItemLayout.getChildAt(i);
            if(child instanceof EditText)
                items[i] = ((EditText)child).getText().toString();
        }
        savedInstanceState.putStringArray("items",items);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void guardarLista(){
        ListaDeCompra listaDeCompra = new ListaDeCompra();

        for (int i=0;i<addItemLayout.getChildCount();i++) {
            View child = addItemLayout.getChildAt(i);
            //evitar los los productos en blanco
            if (child instanceof EditText && !((EditText) child).getText().toString().trim().isEmpty()) {
                listaDeCompra.addProducto(new Producto(((EditText) child).getText().toString(), false));
            }
        }

        //llamar la lista de compras
        ArrayList<ListaDeCompra> compras = getActivity().getIntent().getParcelableArrayListExtra("compras");
        //comprobar si la lista de compras es igual a null
        if(compras == null){
            compras = new ArrayList<>();
        }

        //añadir la nuesta lista a la lista de compras hasta un maximo de 3

        if(compras.size() < 3){

            if(listaDeCompra.getProductos().size() > 0) {
                compras.add(listaDeCompra);
                //guardar la lista de compras
                getActivity().getIntent().putParcelableArrayListExtra("compras", compras);
                Toast toast1 = Toast.makeText(getContext(), "Lista guardada!", Toast.LENGTH_SHORT);
                toast1.show();

            }else {
                Toast toast1 = Toast.makeText(getContext(), "No se puede guardar una lista vacia!!", Toast.LENGTH_SHORT);
                toast1.show();

            }


        }else {
            Toast.makeText(getContext(), "No es posible guardar más de 3 listas!!", Toast.LENGTH_SHORT).show();
        }





    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additem, null);

        //contructor par listas lógicas
      //  compras = new ArrayList<>();




        //fin contructor listas lógicas


        buttonAddItem = (Button)view.findViewById(R.id.buttonAddItem);
        buttonAddItemGuardar = (Button)view.findViewById(R.id.addItem_guardar);

        EditText editText = new EditText(getContext());
        addItemLayout = (LinearLayout)view.findViewById(R.id.add_itemLayout);


        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(null);
                Toast toast1 = Toast.makeText(getContext(), "Nuevo EditText", Toast.LENGTH_SHORT);

            }
        });

        //botón gurdar
        buttonAddItemGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarLista();

            }
        });





        //getActivity() recuperar referencia actividad padre -> sustituye contexto de ejecución

                //aquí codigó del botón


        return view;
    }

    private void addItem(String content) {

        EditText editNewItem = new EditText(getContext());
        editNewItem.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        if(content!=null)
            editNewItem.setText(content);

        addItemLayout.addView(editNewItem);
    }




    @Override
    public void onResume() {
        super.onResume();
//        ArrayList<Item> itemList = Item.getItemList(getContext());
//        ItemAdapter itemAdapter = new ItemAdapter(getContext(), itemList);
    }
}
