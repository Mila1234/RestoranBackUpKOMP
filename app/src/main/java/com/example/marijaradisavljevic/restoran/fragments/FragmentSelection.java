package com.example.marijaradisavljevic.restoran.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.Spinner;

import com.example.marijaradisavljevic.restoran.R;

/**
 * Created by marija.radisavljevic on 5/13/2016.
 */
public class FragmentSelection extends Fragment {

    private static Fragment instance ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mRoot = inflater.inflate(R.layout.selector_layout,container,false);
        Spinner number_of_table = (Spinner)  mRoot.findViewById(R.id.numbreOfTable_spinner);
        Spinner isItPaid = (Spinner)  mRoot.findViewById(R.id.isItPaid_spinner);
        Spinner kategory = (Spinner)  mRoot.findViewById(R.id.kategory_spinner);


        ArrayAdapter<CharSequence> adapter_number_of_table = ArrayAdapter.createFromResource(this.getContext(),
                R.array.numbers, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_number_of_table.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        number_of_table.setAdapter(adapter_number_of_table);


        ArrayAdapter<CharSequence>  adapter_isItPaid = ArrayAdapter.createFromResource(this.getContext(),
                R.array.paidNotpaid, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_isItPaid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        isItPaid.setAdapter(adapter_isItPaid);


        ArrayAdapter<CharSequence> adapter_kategory = ArrayAdapter.createFromResource(this.getContext(),
                R.array.kategory_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_kategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        kategory.setAdapter(adapter_kategory);





        CheckedTextView all =(CheckedTextView) mRoot.findViewById(R.id.all_checkedTextView);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return mRoot;
    }

    public static Fragment getInstance() {


        if(instance == null){
            return new FragmentList();
        }else return instance;

    }
}
