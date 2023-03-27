package org.example.model;

public class Taxes {
    private int ID;
    private int PersonID;
    private int UserTaxes;

    @Override
    public String toString() {
        return "Taxes{" +
                "ID=" + ID +
                ", PersonID=" + PersonID +
                ", UserTaxes=" + UserTaxes +
                '}';
    }

    public Taxes() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public int getUserTaxes() {
        return UserTaxes;
    }

    public void setUserTaxes(int userTaxes) {
        UserTaxes = userTaxes;
    }
}
