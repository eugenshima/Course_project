package com.example.salaryclient.Model;

public class Role {
    private int rID;
    private int PersonID;

    public Role(int rID, int personID, String URole) {
        this.rID = rID;
        PersonID = personID;
        this.URole = URole;
    }

    private String URole;

    public Role() {
    }


    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getURole() {
        return URole;
    }

    public void setURole(String URole) {
        this.URole = URole;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    @Override
    public String toString() {
        return "ID = " + rID +
                "\nURole = '" + URole + '\'' +
                "\n----------------------------------------------------------------------------";
    }
}
