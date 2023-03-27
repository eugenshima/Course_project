package org.example.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private int ID;
    private String UserFName;
    private String UserLName;
    private String PhoneNumber;
    private String email;

    public Person() {

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
        return "person{" +
                "idPerson=" + ID +
                ", FirstName='" + UserFName + '\'' +
                ", LastName='" + UserLName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
