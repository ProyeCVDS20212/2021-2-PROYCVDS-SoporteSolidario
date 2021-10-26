package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Customer;

public interface CustomerDAO {
    
    List<Customer> inicioSesion(String username) throws PersistenceException;
}
