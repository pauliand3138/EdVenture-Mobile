package com.example.adventure.Model;

public class User {
    private String userID;
    private String userName;
    private String userPassword;

    public User() {

    }

    public User(String n, String p) {
        userName = n;
        userPassword = p;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String custID) {
        this.userID = custID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }


    public void setUserName(String n) {
        userName = n;
    }

    public void setUserPassword(String p) {
        userPassword = p;
    }

}
