package edu.eci.cvds.dao;

public class PersistenceException extends Exception{
    public PersistenceException(String mensaje, Exception e){
        super(mensaje + e.toString());
    }

    public PersistenceException(String mensaje){
        super(mensaje);
    }
}
