package edu.eci.cvds.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import org.apache.ibatis.javassist.bytecode.SignatureAttribute.NestedClassType;

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
    public List<Necesidad> consultarNecesidadesAsociadas(int name) throws PersistenceException {
        try {
            return needsMapper.consultarNecesidadesAsociadas(name);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public void actualizarEstadoNecesidad(int idsolicitante,String nombre, String estado) throws PersistenceException {
        try {
            needsMapper.actualizarEstadoNecesidad(idsolicitante,nombre, estado);
        } catch (Exception e) {
            throw new PersistenceException("No se pudo actualizar la necesidad", e);
        }
        
    }
    
    
}
