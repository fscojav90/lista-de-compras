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

import androidx.fragment.app.Fragment;

public class AddItemFragment extends Fragment {

    Button buttonAddItem;
    LinearLayout addItemLayout;

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




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_additem, null);


        buttonAddItem = (Button)view.findViewById(R.id.buttonAddItem);

        EditText editText = new EditText(getContext());
        addItemLayout = (LinearLayout)view.findViewById(R.id.add_itemLayout);


        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(null) ;
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
