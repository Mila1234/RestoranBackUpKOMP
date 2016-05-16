package com.example.marijaradisavljevic.restoran.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.R;

/**
 * Created by marija.radisavljevic on 5/12/2016.
 */
public class FragmentUserInfo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mRoot = inflater.inflate(R.layout.user_info, container, false);
        getActivity().setTitle(R.string.fragmentUserInfo);

        ///////////////////////////////////////////////////////////////////////
        EditText username = (EditText) mRoot.findViewById(R.id.username);
        EditText name = (EditText) mRoot.findViewById(R.id.name);
        EditText surname = (EditText) mRoot.findViewById(R.id.surname);
        EditText number = (EditText) mRoot.findViewById(R.id.number);
        EditText email = (EditText) mRoot.findViewById(R.id.email);
        Button button_ok = (Button) mRoot.findViewById(R.id.ok_button);

        username.setText("MARIJARAD89");
        name.setText("Marija");
        surname.setText("Radisavljevic");
        number.setText("0608861715");
        email.setText("marijarad89@gmail.com");

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), " Snimljeno ", Toast.LENGTH_LONG).show();

                //go to main fragment
            }
        });


        return mRoot;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
