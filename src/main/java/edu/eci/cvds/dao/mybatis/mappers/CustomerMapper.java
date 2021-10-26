package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Customer;

public interface CustomerMapper {
    
    /**
     * Retorna la lista de clientes que se desean consultar apartir del username
     * @param username
     * @return lista de clientes
     */
    List<Customer> inicioSesion(@Param("Username")String username);
}
