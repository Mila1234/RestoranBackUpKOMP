package com.example.marijaradisavljevic.restoran.activiry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.fragments.FragmentLogin;
import com.example.marijaradisavljevic.restoran.fragments.FragmentUserInfo;
import com.example.marijaradisavljevic.restoran.fragments.FreagmentAddOrder;


/**
 * Created by marija.radisavljevic on 5/16/2016.
 */
public class ActivityFirst extends AppCompatActivity {
private static boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_frame);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setNavigationIcon(R.drawable.back);
        //toolbar.setNavigationContentDescription(getResources().getString(R.string.nameOfApp));
       // toolbar.setLogo(R.drawable.help);
        toolbar.setLogoDescription(getResources().getString(R.string.Logo_description));

      //  getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        String fragmetnName;

        if (extras != null) {
            fragmetnName = extras.getString("name");

            if(fragmetnName.equals("FragmentUserInfo")) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentUserInfo fragmentUserInfo = FragmentUserInfo.getInstance();
                fm.beginTransaction().replace(R.id.container_menu, fragmentUserInfo).commit();
            }else if(fragmetnName.equals("FreagmentAddOrder")){
                String action = extras.getString("action");
                if (action.equals("plusbutton")){
                    FragmentManager fm = getSupportFragmentManager();
                    FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
                    Bundle bundle = new Bundle();
                    bundle.putString("action","plusbutton");
                    freagmentAddOrder.setArguments(bundle);
                    fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
                }else{
                    if (action.equals("onclick")){
                        FragmentManager fm = getSupportFragmentManager();
                        FreagmentAddOrder freagmentAddOrder = FreagmentAddOrder.getInstance();
                        Bundle bundle = new Bundle();
                        bundle.putString("rezervationId",extras.getString("rezervationId"));
                        bundle.putString("action","onclick");
                        freagmentAddOrder.setArguments(bundle);
                        fm.beginTransaction().replace(R.id.container_menu, freagmentAddOrder).commit();
                    }else{
                        //TODO
                    }
                }

            }
        }else
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentLogin fragmentLogin = FragmentLogin.getInstance();
            fm.beginTransaction().replace(R.id.container_menu, fragmentLogin).commit();

        }



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
                Intent intent = new Intent(getApplicationContext(), ActivityFirst.class);
                intent.putExtra("name","FragmentUserInfo");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
                return true;
            case R.id.action_logout:
                //call popup win for logout
                return true;
            case R.id.action_add:

                Intent intent2 = new Intent(getApplicationContext(), ActivityFirst.class);
                intent2.putExtra("name", "FreagmentAddOrder");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }




}
