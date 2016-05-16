package com.example.marijaradisavljevic.restoran.activiry;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.fragments.FragmentLogin;



/**
 * Created by marija.radisavljevic on 5/16/2016.
 */
public class ActivityFirst extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_frame);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
        //toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));

        FragmentManager fm = getSupportFragmentManager();
        FragmentLogin fragmentLogin = FragmentLogin.getInstance();
        fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_gui, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_user_info:
                //method();
                return true;
            case R.id.action_logout:
                //method();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }





}
