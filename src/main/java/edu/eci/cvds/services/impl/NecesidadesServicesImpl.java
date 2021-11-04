package edu.eci.cvds.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;

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

    public int consultarNecesidadesAsociadas(int solicitante , boolean estado) throws ExceptionService{
        try {
            return necesidadDao.consultarNecesidadesAsociadas(solicitante, estado);
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
    
}
