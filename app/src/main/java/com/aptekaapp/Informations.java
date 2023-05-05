package com.aptekaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Informations extends AppCompatActivity {

    MaterialButton deliveryBtn, stateBtn, aboutUsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);

        deliveryBtn = findViewById(R.id.deliveryBtn);
        stateBtn = findViewById(R.id.stateBtn);
        aboutUsBtn = findViewById(R.id.aboutUsBtn);


        deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Informations.this, DeliveryInfo.class);
                startActivity(intent);
            }
        });

        stateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Informations.this, StateInfo.class);
                startActivity(intent);
            }
        });

        aboutUsBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Informations.this, AboutUs.class);
                startActivity(intent);
            }
        }));
    }
}