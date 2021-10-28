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
             int values = necesidadDao.consultarNecesidadesAsociadas(need.getIdsolicitante());
             List<Necesidad> repes= necesidadDao.consultar(need.getNombre());
            if (values < rolesDAO.limiteNecesidades(customerDAO.nombreUsuario(need.getIdsolicitante()).get(0).getRol()) && repes.isEmpty()){
                necesidadDao.agregarNecesidades(need);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Necesidad creada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            else if(!repes.isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La necesidad ya existe");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }else{FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
            "Tienes el maximo numero de solicitudes activas");
    PrimeFaces.current().dialog().showMessageDynamic(message);

            }
        } catch (PersistenceException ex) {
            throw new ExceptionService("Error al agregar la necesidad",ex);
        }
        
    }
    
}
