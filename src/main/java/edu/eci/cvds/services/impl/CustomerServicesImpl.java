package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;

import edu.eci.cvds.entities.Customer;
import edu.eci.cvds.services.*;
import edu.eci.cvds.dao.CustomerDAO;

import java.util.List;

public class CustomerServicesImpl implements CustomerServices {

    @Inject
    CustomerDAO customerDAO;

    /**
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     * @throws ExceptionService controlador de errores de la capa de services
     */
    @Override
    public List<Customer> ingresarSesion(String username) throws ExceptionService {
        try {
            return customerDAO.inicioSesion(username);
        } catch (PersistenceException e) {
            throw new ExceptionService("Error al ingresar sesion"+e);
        }
    }


    /**
     * @return Devuelve el nombre de usuario apartir del id
     */
    @Override
    public List<Customer> nombreUsuario(int id) throws ExceptionService{
        try {
            return customerDAO.nombreUsuario(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ExceptionService("Error al iniciar sesion: "+e);
        }
    }
}
