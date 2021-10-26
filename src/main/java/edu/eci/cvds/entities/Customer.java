package edu.eci.cvds.entities;

import java.io.Serializable;

public class Customer implements Serializable{
    private int CustomerID;
    private String Name;
    private String Username;
    private String Passwd;
    private int Rol;
    private String Email;
    private char IsActive;

    public Customer(String name, String username, String passwd, int rol, char isActive, String email){
        this.Name = name;
        this.Username = username;
        this.Passwd = passwd;
        this.Rol = rol;
        this.IsActive = isActive;
        this.Email = email;
    }

    public int getRol() {
        return Rol;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public char getIsActive() {
        return IsActive;
    }

    public String getName() {
        return Name;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setIsActive(char isActive) {
        this.IsActive = isActive;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    public void setRol(int rol) {
        this.Rol = rol;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + CustomerID +
                ", name='" + Name + '\'' +
                ", username='" + Username + '\'' +
                ", passwd='" + Passwd + '\'' +
                ", rol=" + Rol +
                ", isActive=" + IsActive +
                ", email='" + Email + '\'' +
                '}';
    }
}
