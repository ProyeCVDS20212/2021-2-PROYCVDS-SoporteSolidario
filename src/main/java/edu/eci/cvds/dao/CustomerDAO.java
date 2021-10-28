package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Customer;

public interface CustomerDAO {
    
    /**
     * Retorna la lista de clientes que se desean consultar apartir del username
     * @param username
     * @return lista de clientes
     * @exception Excepcion en caso de que no se pueda hacer el inicio de sesion
     */
    List<Customer> inicioSesion(String username) throws PersistenceException;

    List<Customer> nombreUsuario(int id) throws PersistenceException;

}
