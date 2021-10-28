package edu.eci.cvds.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.NecesidadesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.NecesidadesMapper;
import edu.eci.cvds.entities.Necesidad;

public class MyBatisNecesidadesDAO implements NecesidadesDAO {
    @Inject
    NecesidadesMapper needsMapper;

    @Override
    public void agregarNecesidades(Necesidad need) throws PersistenceException {
        try {
            needsMapper.agregarNecesidades(need);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
        
    }

    @Override
    public List<Necesidad> consultar(String name) throws PersistenceException {
        try {
            return needsMapper.consultar(name);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public int consultarNecesidadesAsociadas(int name) throws PersistenceException {
        try {
            return needsMapper.consultarNecesidadesAsociadas(name).size();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
    
}
