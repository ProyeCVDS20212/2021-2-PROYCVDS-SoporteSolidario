package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.dao.mybatis.mappers.RolesMapper;

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
    

        
}
