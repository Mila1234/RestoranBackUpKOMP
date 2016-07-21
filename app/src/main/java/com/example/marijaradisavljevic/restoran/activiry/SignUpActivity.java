package com.example.marijaradisavljevic.restoran.activiry;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marijaradisavljevic.restoran.R;
import com.example.marijaradisavljevic.restoran.firebaseservis.Constants;
import com.example.marijaradisavljevic.restoran.firebaseservis.ServisFirebase;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class SignUpActivity extends AppCompatActivity {

    protected EditText passwordEditText;
    protected EditText emailEditText;
    protected Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        passwordEditText = (EditText)findViewById(R.id.passwordField);
        emailEditText = (EditText)findViewById(R.id.emailField);
        signUpButton = (Button)findViewById(R.id.signupButton);

        final Firebase ref = new Firebase(Constants.FIREBASE_URL);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServisFirebase.getInstance().setCallingactivity(SignUpActivity.this);
                ServisFirebase.getInstance().createUser(emailEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });
    }
}