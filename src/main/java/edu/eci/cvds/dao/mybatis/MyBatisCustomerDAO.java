package edu.eci.cvds.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.CustomerDAO;
import edu.eci.cvds.dao.mybatis.mappers.CustomerMapper;
import edu.eci.cvds.entities.Customer;

public class MyBatisCustomerDAO implements CustomerDAO{
    @Inject
    CustomerMapper customerMapper;

    /**
     * Retorna la lista de clientes que se desean consultar apartir del username
     * @param username
     * @return lista de clientes
     * @exception Excepcion en caso de que no se pueda hacer el inicio de sesion
     */
    @Override
    public List<Customer> inicioSesion(String username) throws PersistenceException {
        try {
            return customerMapper.inicioSesion(username);
        } catch (Exception e) {
            throw new PersistenceException("Inicio de sesion errado",e);
        }
        
    }

    @Override
    public List<Customer> nombreUsuario(int id) throws PersistenceException {
        try {
            return customerMapper.nombreUsuario(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    
    }

}
