package com.example.marijaradisavljevic.restoran.application;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by echessa on 3/10/16.
 */
public class ToDoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}