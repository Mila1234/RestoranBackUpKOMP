package com.example.marijaradisavljevic.restoran.activitylog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.activiryuser.ActivityFirst;
import com.example.marijaradisavljevic.restoran.firebaseservis.ServisFireBase;

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
        toolbar.setSubtitle(ServisFireBase.getInstance().toolBarTypeNameSurnameString());

        Button ok =  (Button) findViewById(R.id.ok_button);
        assert ok != null;
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityLogout.this, "Odjava", Toast.LENGTH_LONG).show();

                Intent intent2 = new Intent(getApplicationContext(), ActivityFirst.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent2);

            }
        });
        Button cancel =  (Button) findViewById(R.id.cancel_button);

        assert cancel != null;
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityLogout.this, "Odustajem", Toast.LENGTH_LONG).show();

                onBackPressed();


            }
        });


    }


}
