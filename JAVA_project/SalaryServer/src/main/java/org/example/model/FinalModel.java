package org.example.model;

public class FinalModel {
    private int PersonID;
    private String Name;
    private String Surname;
    private String Role;
    private int Salary;
    private int taxes;
    private int DaysWorked;

    public FinalModel() {
    }

    public FinalModel(int personID, String name, String surname, String role, int salary, int taxes, int daysWorked) {
        PersonID = personID;
        Name = name;
        Surname = surname;
        Role = role;
        Salary = salary;
        this.taxes = taxes;
        DaysWorked = daysWorked;
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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public int getDaysWorked() {
        return DaysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        DaysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "FinalModel{" +
                "PersonID=" + PersonID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Role='" + Role + '\'' +
                ", Salary=" + Salary +
                ", taxes=" + taxes +
                ", DaysWorked=" + DaysWorked +
                '}';
    }
}
