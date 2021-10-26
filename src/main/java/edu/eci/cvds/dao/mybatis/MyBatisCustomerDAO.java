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

    @Override
    public List<Customer> inicioSesion(String username) throws PersistenceException {
        try {
            return customerMapper.inicioSesion(username);
        } catch (Exception e) {
            throw new PersistenceException("Inicio de sesion errado",e);
        }
        
    }
    
}
