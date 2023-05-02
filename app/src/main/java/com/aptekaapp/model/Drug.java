package com.aptekaapp.model;

import java.util.Scanner;

public class Drug {

    String drugName;
    String manufacturer;
    String description;
    Double price;
    int quantity;
    int PrescriptionNumber;
    boolean isPrescription;
    boolean hasPrescription;


    public Drug() {

    }

    public Drug(String drugName, String manufacturer,
                String description, Double price, int quantity, boolean isPrescription) {
        this.drugName = drugName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.isPrescription = isPrescription;
    }

    public boolean isHasPrescription() {
        return hasPrescription;
    }

    public void setHasPrescription(boolean hasPrescription) {
        this.hasPrescription = hasPrescription;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPrescription() {
        return isPrescription;
    }

    public void setPrescription(boolean prescription) {
        isPrescription = prescription;
    }

      //***********************************************************|
      // this method checks is prescription needed to buy this drug|
      //***********************************************************|
    public void checkIsPrescription() {
        if (isPrescription == true) {
            System.out.println("Musisz posiadać receptę, aby zakupić ten lek");
        } else {
            System.out.println("Lek sprzedawany bez recepty");
        }
    }

    //**************************************************|
    // this method checks if customer has a prescription|
    //**************************************************|

    public void hasPrescription() {
        if (hasPrescription == true) {
            System.out.println("Podaj nr recepty");
            Scanner input = new Scanner(System.in);
            PrescriptionNumber = input.nextInt();

        } else {
            System.out.println("Nie można wydać leku bez recepty");
        }
    }
}
