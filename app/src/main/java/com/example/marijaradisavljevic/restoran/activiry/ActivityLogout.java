package com.example.marijaradisavljevic.restoran.activiry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.fragments.FragmentLogin;
import com.example.marijaradisavljevic.restoran.fragments.FragmentUserInfo;
import com.example.marijaradisavljevic.restoran.fragments.FreagmentAddOrder;

/**
 * Created by marija.radisavljevic on 6/8/2016.
 */
public class ActivityLogout extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
        // toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));





    }


}
