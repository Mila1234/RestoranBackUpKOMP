package com.example.marijaradisavljevic.restoran.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.Spinner;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.spiner.MySpinnerAdapter;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentSelection extends Fragment implements AdapterView.OnItemSelectedListener {

    private static Fragment instance ;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mRoot = inflater.inflate(R.layout.fragment_selector_layout,container,false);
        Spinner number_of_table = (Spinner)  mRoot.findViewById(R.id.numbreOfTable_spinner);
        Spinner isItPaid = (Spinner)  mRoot.findViewById(R.id.isItPaid_spinner);
        Spinner kategory = (Spinner)  mRoot.findViewById(R.id.kategory_spinner);

        String[] value = getResources().getStringArray(R.array.numbers);
        ArrayAdapter<String> adapter_number_of_table = new MySpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,value);



        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        number_of_table.setAdapter(adapter_number_of_table);
        number_of_table.setSelection(adapter_number_of_table.getCount());


         value = getResources().getStringArray(R.array.paidNotpaid);
        ArrayAdapter<String>  adapter_isItPaid = new MySpinnerAdapter(getActivity(),
                 android.R.layout.simple_spinner_item ,value);

        // Specify the layout to use when the list of choices appears
        adapter_isItPaid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        isItPaid.setAdapter(adapter_isItPaid);
        isItPaid.setSelection(isItPaid.getCount());


         value = getResources().getStringArray(R.array.kategory_array);
        ArrayAdapter<String> adapter_kategory = new MySpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item,value );

        // Specify the layout to use when the list of choices appears
        adapter_kategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        kategory.setAdapter(adapter_kategory);
        kategory.setSelection(kategory.getCount());


       final CheckedTextView all =(CheckedTextView) mRoot.findViewById(R.id.all_checkedTextView);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(all.isChecked()){
                    all.setChecked(false);
                }else{
                    all.setChecked(true);
                }
            }
        });
        return mRoot;
    }

    public static Fragment getInstance() {


        if(instance == null){
            return new FragmentListReservations();
        }else return instance;

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_logout).setVisible(true);
        menu.findItem(R.id.action_user_info).setVisible(true);
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
if(position == 0 ){return;}
        switch (view.getId()) {
            case R.id.isItPaid_spinner:
                break;
            case R.id.kategory_spinner:
                break;
            case R.id.numbreOfTable_spinner:
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
