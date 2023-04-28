package com.aptekaapp.model;

import android.widget.Toast;


public class User {
    String email;
    String firstName;
    String lastName;
    String password;
    String pesel;


    public User () {

    }

    public User(String email, String firstNamename, String lastName, String password, String pesel) {
        this.email = email;
        this.firstName = firstName;
        this. lastName = lastName;
        this.password = password;
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPesel() {
        return pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void checkEmail() {
        if(email.isEmpty() && email.charAt(1) != '@') {
            System.out.println("Podaj poprawny email!");
        }
    }

    public void checFirstkName() {
        if (firstName.isEmpty() && firstName.length() > 2) {
            System.out.println("Podaj poprawne imię!");
        }
    }

    public void checkLastName() {
        if (lastName.isEmpty() && lastName.length() > 2) {
            System.out.println("Podaj poprawne nazwisko!");
        }
    }

    public void checkPesel() {
        if(pesel.isEmpty() && pesel.length() > 10){
            System.out.println("Podaj poprawny PESEL");
        }
    }
    public void checkPassword() {
        if (password.length() > 4) {
            System.out.println("Hasło powinno zawierać conajmniej 5 znaków!");
        }
    }

}
