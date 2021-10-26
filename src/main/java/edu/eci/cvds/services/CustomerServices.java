package edu.eci.cvds.services;

import edu.eci.cvds.entities.Customer;

import java.util.List;

public interface CustomerServices {

    /**
     * Se obtiene una lista con los clientes consultado
     * @param username  Username que se va a consultar
     * @return Lista de clientes
     * @throws ExceptionService controlador de errores de la package de service
     */

    List<Customer> IngresarSesion(String username) throws ExceptionService;
    List<Customer> NombreUsuario(int id) throws ExceptionService;
}
