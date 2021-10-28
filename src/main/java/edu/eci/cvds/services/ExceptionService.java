package edu.eci.cvds.services;

/**
     * Constructor cuando se recibe unicamente el mensaje de la excepcion
     * @param mensaje
     */
public class ExceptionService extends Exception {
    public ExceptionService(String message){
        super(message);
    }

    /**
     * Constructor cuando se recibe el  mensaje de la excepcion y la excepcion
     * @param mensaje
     * @param e
     */
    public ExceptionService(String message, Exception e){
        super(message + e.toString());
    }
}
