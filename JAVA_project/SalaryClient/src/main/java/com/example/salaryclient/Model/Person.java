package com.example.salaryclient.Model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private int ID;
    private String UserFName;
    private String UserLName;
    private String PhoneNumber;
    private String email;
    private Date DateOfBirth;

    public Person() {

    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getUserFName() {
        return UserFName;
    }

    public String getUserLName() {
        return UserLName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setUserFName(String userFName) {
        UserFName = userFName;
    }

    public void setUserLName(String userLName) {
        UserLName = userLName;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ID = " + ID +
                "\nFirstName = '" + UserFName + '\'' +
                "\nLastName = '" + UserLName + '\'' +
                "\nPhoneNumber = '" + PhoneNumber + '\'' +
                "\nemail = '" + email + '\'' +
                "\n----------------------------------------------------------------------------";
    }
}