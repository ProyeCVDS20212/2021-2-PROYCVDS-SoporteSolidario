package edu.eci.cvds.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;


import edu.eci.cvds.dao.CustomerDAO;
import edu.eci.cvds.dao.NecesidadesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;

public class NecesidadesServicesImpl implements NecesidadesServices{
@Inject
NecesidadesDAO necesidadDao;

@Inject
RolesDAO rolesDAO;

@Inject
CustomerDAO customerDAO;

    @Override
    public void agregarNecesidades(Necesidad need) throws ExceptionService {
        try {
            necesidadDao.agregarNecesidades(need);
        } catch (PersistenceException ex) {
            throw new ExceptionService("Error al agregar la necesidad",ex);
        }
        
    }

    public List<Necesidad> consultarNecesidadesAsociadas(int solicitante) throws ExceptionService{
        try {
            return necesidadDao.consultarNecesidadesAsociadas(solicitante);
        } catch (PersistenceException e) {
            throw new ExceptionService("Error en la consulta",e);
        }
    }
    public int consultarNecesidadesAsociadasA(int solicitante) throws ExceptionService{
        try {
            List<Necesidad> temp = new ArrayList<>();
            for(Necesidad n : necesidadDao.consultarNecesidadesAsociadas(solicitante)){
                if(n.getEstado().equals("A")) temp.add(n); 
            }
            return temp.size();
        } catch (PersistenceException e) {
            throw new ExceptionService("Error en la consulta",e);
        }
    }

    @Override
    public List<Necesidad> consultarnecesidad(String nombre) throws ExceptionService {
        try {
            return necesidadDao.consultar(nombre);
        } catch (PersistenceException e) {
            throw new ExceptionService("Error en la consulta",e);
        }
    }

    @Override
    public void actualizarEstadoNecesidad(int idsolicitante,String nombre, String estado) throws ExceptionService {
        try {
            necesidadDao.actualizarEstadoNecesidad(idsolicitante,nombre, estado);
        } catch (Exception e) {
            throw new ExceptionService("No se pudo actualizar el estado de la necesidad", e);
        }
        
    }

    @Override
    public List<Necesidad> consultarNecesidades() throws ExceptionService {
        try {
            return necesidadDao.consultarNecesidades();
        } catch (Exception e) {
            throw new ExceptionService("No se pudo actualizar el estado de la necesidad", e);
        }
    }

    @Override
    public int consultarNecesidadCategorias(int necesidad) throws ExceptionService {
        try {
            return necesidadDao.consultarNecesidadCategorias(necesidad);
        } catch (Exception e) {
            throw new ExceptionService("No se pudo actualizar el estado de la necesidad", e);
        }
    }
    
}
