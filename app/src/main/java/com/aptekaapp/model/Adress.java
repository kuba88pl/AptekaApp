package com.aptekaapp.model;

import android.provider.Telephony;

public class Adress {
    String city;
    String street;
    String postalCode;
    int apartmentNumber;
    int homeNumber;

    public Adress() {

    }

    public Adress (String city, String street, String postalCode, int apartmentNumber, int homeNumber) {
        this.city =city;
        this.street = street;
        this.postalCode = postalCode;
        this.apartmentNumber = apartmentNumber;
        this.homeNumber = homeNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }
}
