package com.example.salaryclient.Model;

import java.io.Serializable;

public class ReportCard implements Serializable {
    private int RCID;
    private int PersonID;
    private String Name;
    private String Surname;
    private int DaysWorked;

    public ReportCard() {

    }

    public ReportCard(int RCID, int personID, String name, String surname, int daysWorked) {
        this.RCID = RCID;
        PersonID = personID;
        Name = name;
        Surname = surname;
        DaysWorked = daysWorked;
    }

    public int getRCID() {
        return RCID;
    }

    public void setRCID(int RCID) {
        this.RCID = RCID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getDaysWorked() {
        return DaysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        DaysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "ID = " + PersonID +
                "\nName = '" + Name + '\'' +
                "\nSurname = '" + Surname + '\'' +
                "\nDaysWorked = " + DaysWorked +
                "\n----------------------------------------------------------------------------";
    }
}

