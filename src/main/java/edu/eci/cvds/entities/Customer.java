package edu.eci.cvds.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customer implements Serializable{
    private int CustomerID;
    private String Name;
    private String Username;
    private String Passwd;
    private int Rol;
    private String Email;
    private boolean IsActive;

    /**
     * Constructor de la clase Customer
     * @param name nombre del cliente
     * @param username username del cliente
     * @param passwd contraseña del usuario
     * @param rol el rol que posee el cliente
     * @param isActive booleano para ver si esta activo el cliente
     * @param email correo del cliente
     */
    public Customer(BigDecimal customerID,String name, String username, String passwd, BigDecimal rol, String email, boolean isActive){
        this.CustomerID = customerID.intValue();
        this.Name = name;
        this.Username = username;
        this.Passwd = passwd;
        this.Rol = rol.intValue();
        this.IsActive = isActive;
        this.Email = email;
    }

    /**
     * 
     * @return el rol que tiene el cliente
     */
    public int getRol() {
        return Rol;
    }

    /**
     * 
     * @return el ID del cliente
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /***
     * 
     * @return el correo del cliente
     */
    public String getEmail() {
        return Email;
    }

    /**
     * 
     * @return el username del cliente
     */
    public String getUsername() {
        return Username;
    }

    /**
     * 
     * @return el estado del cliente, si esta activo o no
     */
    public boolean getIsActive() {
        return IsActive;
    }

    /**
     * 
     * @return el nombre del usuario
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @return la contraseña del cliente
     */
    public String getPasswd() {
        return Passwd;
    }

    /**
     * Asigna el ID del cliente
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    /**
     * Asigna el email del cliente
     * @param email
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * Asigna el estado del cliente. True si esta activo y False si no
     * @param isActive
     */
    public void setIsActive(boolean isActive) {
        this.IsActive = isActive;
    }

    /**
     * Asigna el nombre del cliente
     * @param name
     */
    public void setName(String name) {
        this.Name = name;
    }

    /**
     * Asigna la contraseña del cliente
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    /**
     * Asigna el rol del cliente
     * @param rol
     */
    public void setRol(int rol) {
        this.Rol = rol;
    }

    /**
     * Asigna el username del cliente
     * @param username
     */
    public void setUsername(String username) {
        this.Username = username;
    }

    /**
     * Retorna toda la informacion del cliente en forma de string
     */
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
