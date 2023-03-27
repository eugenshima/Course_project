package org.example.model;

import java.io.Serializable;

public class FinalSalary implements Serializable {
    private int idFS;
    private int PersonID;
    private int rolesID;
    private int taxesID;
    private int ReportCardID;
    private double FS;

    public FinalSalary() {
    }

    public FinalSalary(int idFS, int personID, int rolesID, int taxesID, int reportCardID, int FS) {
        this.idFS = idFS;
        PersonID = personID;
        this.rolesID = rolesID;
        this.taxesID = taxesID;
        ReportCardID = reportCardID;
        this.FS = FS;
    }

    public int getIdFS() {
        return idFS;
    }

    public void setIdFS(int idFS) {
        this.idFS = idFS;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }



    public int getReportCardID() {
        return ReportCardID;
    }

    public void setReportCardID(int reportCardID) {
        ReportCardID = reportCardID;
    }

    public double getFS() {
        return FS;
    }

    public void setFS(double FS) {
        this.FS = FS;
    }

    public int getRolesID() {
        return rolesID;
    }

    public void setRolesID(int rolesID) {
        this.rolesID = rolesID;
    }

    public int getTaxesID() {
        return taxesID;
    }

    public void setTaxesID(int taxesID) {
        this.taxesID = taxesID;
    }

    @Override
    public String toString() {
        return "FinalSalary{" +
                "idFS=" + idFS +
                ", PersonID=" + PersonID +
                ", rolesID=" + rolesID +
                ", taxesID=" + taxesID +
                ", ReportCardID=" + ReportCardID +
                ", FS=" + FS +
                '}';
    }
}
