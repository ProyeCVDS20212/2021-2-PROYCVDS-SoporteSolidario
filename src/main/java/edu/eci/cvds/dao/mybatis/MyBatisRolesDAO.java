package edu.eci.cvds.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.dao.mybatis.mappers.RolesMapper;
import edu.eci.cvds.entities.Rol;

public class MyBatisRolesDAO implements RolesDAO {
    @Inject
    RolesMapper rolMapper;


    @Override
    public int limiteNecesidades(int id) throws PersistenceException {
        try {
            return rolMapper.consultarRol(id).get(0).getLimiteSolicitudes();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar", e);
        }        
    }


    @Override
    public int limiteOfertas(int id) throws PersistenceException {
        try {
            return rolMapper.consultarRol(id).get(0).getLimiteOfertas();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar", e);
        }   
    }


    @Override
    public String getRol(int id) throws PersistenceException {
        try {
            return rolMapper.consultarRol(id).get(0).getNombre();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar", e);
        }  
    }
    

        
}
