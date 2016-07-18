package com.example.marijaradisavljevic.restoran.activiry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by marija.radisavljevic on 7/18/2016.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Intent intent = new Intent(getApplicationContext(), ActivityFirst.class);
        getApplicationContext().startActivity(intent);
    }

}
