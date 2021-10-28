package edu.eci.cvds.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.dao.NecesidadesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;

public class NecesidadesServicesImpl implements NecesidadesServices{
@Inject
NecesidadesDAO necesidadDao;

    @Override
    public void agregarNecesidades(Necesidad need) throws ExceptionService {
        try {
            List<Necesidad> values = necesidadDao.consultar(need.getNombre());
            if (values.isEmpty()){
                necesidadDao.agregarNecesidades(need);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Necesidad creada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La necesidad ya existe");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (PersistenceException ex) {
            throw new ExceptionService("Error al agregar la necesidad",ex);
        }
        
    }
    
}
