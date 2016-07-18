package com.example.marijaradisavljevic.restoran.firebase;

/**
 * Created by marija.radisavljevic on 7/18/2016.
 */

import android.app.Application;
import com.firebase.client.Firebase;


public class ToDoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}