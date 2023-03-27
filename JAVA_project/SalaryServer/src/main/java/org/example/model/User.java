package org.example.model;

import java.io.Serializable;

public class User implements Serializable {
    private int iduser;
    private int PersonID;

    private String UserLogin;

    private String UserPassword;


    public User() {

    }

    public User(int iduser, int personID, String userLogin, String userPassword) {
        this.iduser = iduser;
        PersonID = personID;
        UserLogin = userLogin;
        UserPassword = userPassword;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String userLogin) {
        UserLogin = userLogin;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", UserLogin='" + UserLogin + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                '}';
    }
}
