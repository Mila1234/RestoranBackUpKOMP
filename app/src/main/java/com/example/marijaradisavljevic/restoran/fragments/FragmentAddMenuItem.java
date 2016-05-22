package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiry.ActivityGUI;
import com.example.marijaradisavljevic.restoran.spiner.MySpinnerAdapter;

/**
 * Created by marija on 22.5.16.
 */
public class FragmentAddMenuItem extends Fragment {

    private static FragmentAddMenuItem instance;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_add_menuItem, container, false);
        getActivity().setTitle(R.string.nameOfApp);

        ///////////////////////////////////////////////////////////////////////

        Button button_ok = (Button) mRoot.findViewById(R.id.ok_button);


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), " Snimljeno ", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity().getApplicationContext(), ActivityGUI.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent);
            }
        });

        Button button_ok = (Button) mRoot.findViewById(R.id.ok_button);


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), " Snimljeno ", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity().getApplicationContext(), ActivityGUI.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent);
            }
        });


        Spinner menu_item_spiner = (Spinner)  mRoot.findViewById(R.id.menu_item_spiner);


        String[] value = getResources().getStringArray(R.array.kategory_array);
        ArrayAdapter<String> menu_item_spiner_adapter = new MySpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        menu_item_spiner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        menu_item_spiner.setAdapter(menu_item_spiner_adapter);
        menu_item_spiner.setSelection(menu_item_spiner_adapter.getCount());



        Spinner number_item_spiner = (Spinner)  mRoot.findViewById(R.id.number_item_spiner);

        String[] value = getResources().getStringArray(R.array.number_item_spiner);
        ArrayAdapter<String> number_item_spiner_adapter = new MySpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,value);
        // Specify the layout to use when the list of choices appears
        number_item_spiner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        number_item_spiner.setAdapter(number_item_spiner_adapter);
        number_item_spiner.setSelection(number_item_spiner_adapter.getCount());

        return mRoot;
    }




    public static FragmentAddMenuItem getInstance() {


        if(instance == null){
            return new FragmentAddMenuItem();
        }else return instance;

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_user_info).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }


}