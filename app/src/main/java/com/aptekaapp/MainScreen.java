package com.aptekaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainScreen extends AppCompatActivity {
    AppCompatImageButton onReciptBtn, nonReciptBtn,
            suplementsBtn, othersBtn, shoppingCartBtn;

    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        auth = FirebaseAuth.getInstance();
        onReciptBtn = findViewById(R.id.onReciptBtn);
        nonReciptBtn = findViewById(R.id.nonReciptBtn);
        suplementsBtn = findViewById(R.id.suplementsBtn);
        othersBtn = findViewById(R.id.othersBtn);
        shoppingCartBtn = findViewById(R.id.shopping_cart);
        user = auth.getCurrentUser();


        onReciptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PrescriptionDrugsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nonReciptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoPrescriptionDrugsActivity.class);
                startActivity(intent);
            }
        });
        othersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), otherDrugs.class);
                startActivity(intent);
            }
        });

        suplementsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), suplementActivity.class);
                startActivity(intent);
            }
        });

        shoppingCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShoppingCart.class);
                startActivity(intent);
            }
        });
    }
}