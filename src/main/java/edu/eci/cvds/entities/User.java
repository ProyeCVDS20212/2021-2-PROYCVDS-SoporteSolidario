package edu.eci.cvds.entities;

import java.io.Serializable;

public class User implements Serializable{
    private int customerID;
    private String name;
    private String username;
    private String passwd;
    private int rol;
    private String email;
    private char isActive;

    public User(String name, String username, String passwd, int rol, char isActive, String email){
        this.name = name;
        this.username = username;
        this.passwd = passwd;
        this.rol = rol;
        this.isActive = isActive;
        this.email = email;
    }

    public int getRol() {
        return rol;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public char getIsActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
