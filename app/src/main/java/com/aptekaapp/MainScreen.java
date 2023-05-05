package com.aptekaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainScreen extends AppCompatActivity {
 MaterialButton logoutBtn;
 TextView textView;
 FirebaseAuth auth;
 FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        auth = FirebaseAuth.getInstance();
        logoutBtn = findViewById(R.id.logoutBtn);
        textView = findViewById(R.id.textView);
        user = auth.getCurrentUser();
        if(user == null) {
            Intent intent  = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            textView.setText(user.getEmail());
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent  = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}