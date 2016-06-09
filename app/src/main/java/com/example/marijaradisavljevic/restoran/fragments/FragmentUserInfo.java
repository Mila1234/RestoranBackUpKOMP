package com.example.marijaradisavljevic.restoran.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiry.ActivityGUI;
import com.example.marijaradisavljevic.restoran.data.UserData;
import com.example.marijaradisavljevic.restoran.database.UserInfo;
import com.example.marijaradisavljevic.restoran.servis.Servis;

/**
 * Created by marija.radisavljevic on 5/12/2016.
 */
public class FragmentUserInfo extends Fragment {

    private static FragmentUserInfo instance;


    private EditText username;
    private EditText name ;
    private EditText surname ;
    private EditText number ;
    private EditText email;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.fragment_user_info_layout, container, false);
        getActivity().setTitle(R.string.fragmentUserInfo);

        ///////////////////////////////////////////////////////////////////////
        username = (EditText) mRoot.findViewById(R.id.username);
         name = (EditText) mRoot.findViewById(R.id.name);
         surname = (EditText) mRoot.findViewById(R.id.surname);
         number = (EditText) mRoot.findViewById(R.id.number);
         email = (EditText) mRoot.findViewById(R.id.email);
        Button button_ok = (Button) mRoot.findViewById(R.id.ok_button);

        UserInfo ui =  Servis.getInstance().getUserInfo(UserData.getInstance().getUsername(),UserData.getInstance().getPassword());

        username.setText(ui.getUsername());
        name.setText(ui.getName());
        surname.setText(ui.getSurname());
        number.setText(ui.getNumber());
        email.setText(ui.getEmail());

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), " Snimljeno ", Toast.LENGTH_LONG).show();

                UserInfo ui = new UserInfo();
                ui.setUsername(username.getText().toString());
                ui.setName(name.getText().toString());
                ui.setSurname(surname.getText().toString());
                ui.setNumber(number.getText().toString());
                ui.setEmail(email.getText().toString());
                Servis.getInstance().setUserInfo(ui);

                UserData.getInstance().setUsername(ui.getUsername());
              //  UserData.getInstance().setUsername(ui.getPasseord());

                Intent intent = new Intent(getActivity().getApplicationContext(), ActivityGUI.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().getApplicationContext().startActivity(intent);
            }
        });


        return mRoot;
    }




    public static FragmentUserInfo getInstance() {


        if(instance == null){
            return new FragmentUserInfo();
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
