package com.example.salaryclient.Model;

import java.io.Serializable;

public class Staffing implements Serializable {
    private int idStaffing;

    private int PersonID;
    private int Casing;
    private int RoleID;

    public Staffing() {
    }

    public Staffing(int idStaffing, int personID, int casing, int roleID) {
        this.idStaffing = idStaffing;
        PersonID = personID;
        Casing = casing;
        RoleID = roleID;
    }

    public int getIdStaffing() {
        return idStaffing;
    }

    public void setIdStaffing(int idStaffing) {
        this.idStaffing = idStaffing;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public int getCasing() {
        return Casing;
    }

    public void setCasing(int casing) {
        Casing = casing;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    @Override
    public String toString() {
        return "ID = " + PersonID +
                "\nCasing = " + Casing +
                "\n----------------------------------------------------------------------------";
    }
}