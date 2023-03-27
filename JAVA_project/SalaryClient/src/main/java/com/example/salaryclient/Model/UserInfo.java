package com.example.salaryclient.Model;

public class UserInfo {
    private int id;
    private String FName;
    private String LName;
    private String PhoneNumber;
    private String email;
    /////////////////
    private String login;
    private String Password;
    private String Role;

    public UserInfo() {
    }

    public UserInfo(int id, String FName, String LName, String phoneNumber, String email, String login, String password, String role) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
        PhoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        Password = password;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "ID = " + id +
                "\nFName = '" + FName + '\'' +
                "\nLName = '" + LName + '\'' +
                "\nPhoneNumber = '" + PhoneNumber + '\'' +
                "\nemail = '" + email + '\'' +
                "\nlogin = '" + login + '\'' +
                "\nPassword = '" + Password + '\'' +
                "\nRole = '" + Role + '\'' +
                "\n----------------------------------------------------------------------------";
    }
}
