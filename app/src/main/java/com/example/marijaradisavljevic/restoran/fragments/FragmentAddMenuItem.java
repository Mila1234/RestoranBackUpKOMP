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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiryuser.ActivityFirst;
import com.example.marijaradisavljevic.restoran.firebaseservis.ServisFireBase;
import com.example.marijaradisavljevic.restoran.spiner.MySpinnerAdapter;

/**
 * Created by marija on 22.5.16.
 */
public class FragmentAddMenuItem extends Fragment {

    private static FragmentAddMenuItem instance;
    private Spinner number_item_spiner;
    private Spinner menu_item_spiner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_add_menu_item, container, false);
        getActivity().setTitle(R.string.nameOfApp);

        ///////////////////////////////////////////////////////////////////////

        Button button_ok = (Button) mRoot.findViewById(R.id.ok_button);


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getActivity(), " Snimljeno ", Toast.LENGTH_LONG).show();
                Bundle extras = getActivity().getIntent().getExtras();
                String rezIdString = extras.getString("rezervation_id");
                ServisFireBase.getInstance().addOrder(Integer.parseInt(rezIdString), number_item_spiner.getSelectedItem().toString(), menu_item_spiner.getSelectedItem().toString());

                Intent intent2 = new Intent(getActivity().getApplicationContext(), ActivityFirst.class);
                intent2.putExtra("name", "FreagmentAddOrder");
                intent2.putExtra("rezervationId", rezIdString);
                intent2.putExtra("action", "onclick");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent2);

            }
        });

        Button cancel_button = (Button) mRoot.findViewById(R.id.cancel_button);


        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Odustali ste ", Toast.LENGTH_LONG).show();

                Bundle extras = getActivity().getIntent().getExtras();
                String rezIdString = extras.getString("rezervation_id");
                Intent intent2 = new Intent(getActivity().getApplicationContext(), ActivityFirst.class);
                intent2.putExtra("name", "FreagmentAddOrder");
                intent2.putExtra("rezervationId", rezIdString);
                intent2.putExtra("action", "onclick");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent2);

            }
        });


         menu_item_spiner = (Spinner)  mRoot.findViewById(R.id.menu_item_spiner);
        //String[] value = getResources().getStringArray(R.array.kategory_array);
        ArrayAdapter<String> menu_item_spiner_adapter = new MySpinnerAdapter(false,getActivity(),
                android.R.layout.simple_spinner_item, ServisFireBase.getInstance().stringListofFoodItems());
        // Specify the layout to use when the list of choices appears
        menu_item_spiner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        menu_item_spiner.setAdapter(menu_item_spiner_adapter);
        menu_item_spiner.setSelection(0);



         number_item_spiner = (Spinner)  mRoot.findViewById(R.id.number_item_spiner);
       // String [] value = getResources().getStringArray(R.array.number_item_spiner);
        ArrayAdapter<String> number_item_spiner_adapter = new MySpinnerAdapter(false,getActivity(),
                android.R.layout.simple_spinner_item, ServisFireBase.getInstance().getNumberItems());
        // Specify the layout to use when the list of choices appears
        number_item_spiner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        number_item_spiner.setAdapter(number_item_spiner_adapter);
        number_item_spiner.setSelection(0);

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
