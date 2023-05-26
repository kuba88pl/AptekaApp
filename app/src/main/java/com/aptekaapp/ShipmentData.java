package com.aptekaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Scanner;

public class ShipmentData extends AppCompatActivity {

    EditText companyNameEditText, nameEditText, lastNameEditText, adressEditText, postalCodeEditText, cityEditText;
    MaterialButton saveChangesBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_data);

        String name, lastName, adress, postalCode, city;

        companyNameEditText = findViewById(R.id.company_name);
        nameEditText = findViewById(R.id.name_edit_text);
        lastNameEditText = findViewById(R.id.lastName_edit_text);
        adressEditText = findViewById(R.id.adress_edit_text);
        postalCodeEditText = findViewById(R.id.postal_code);
        cityEditText = findViewById(R.id.city);
        saveChangesBtn = findViewById(R.id.save_changes);

        name = String.valueOf(nameEditText.getText());
        lastName = String.valueOf(lastNameEditText.getText());
        adress = String.valueOf(adressEditText.getText());
        postalCode = String.valueOf(postalCodeEditText.getText());
        city = String.valueOf(cityEditText.getText());

        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.isEmpty()) {
                    Toast.makeText(ShipmentData.this, "Podaj imię", Toast.LENGTH_SHORT).show();
                }
                if(lastName.isEmpty()) {
                    Toast.makeText(ShipmentData.this, "Podaj nazwisko", Toast.LENGTH_SHORT).show();
                }
                if(adress.isEmpty()) {
                    Toast.makeText(ShipmentData.this, "Podaj poprawny adres", Toast.LENGTH_SHORT).show();
                }
                if(postalCode.isEmpty()) {
                    Toast.makeText(ShipmentData.this, "Podaj kod pocztowy", Toast.LENGTH_SHORT).show();
                }
                if(city.isEmpty()) {
                    Toast.makeText(ShipmentData.this, "Podaj miasto", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}