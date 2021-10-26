package edu.eci.cvds.dao;

public class PersistenceException extends Exception{
    /**
     * Constructor cuando se recibe el  mensaje de la excepcion y la excepcion
     * @param mensaje
     * @param e
     */
    public PersistenceException(String mensaje, Exception e){
        super(mensaje + e.toString());
    }

    /**
     * Constructor cuando se recibe unicamente el mensaje de la excepcion
     * @param mensaje
     */
    public PersistenceException(String mensaje){
        super(mensaje);
    }
}
