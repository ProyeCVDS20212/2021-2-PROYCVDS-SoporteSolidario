package edu.eci.cvds.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.OfertasDAO;
import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.OfertasServices;

public class OfertasServicesImpl implements OfertasServices{
    @Inject
    OfertasDAO ofertasDAO;

    @Override
    public void agregarOferta(Ofertas oferta) throws ExceptionService {
        try {
            ofertasDAO.agregarOferta(oferta);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de agregar la oferta" + e.toString());
        }
        
    }

    @Override
    public List<Ofertas> verificarOferta(String oldnombre) throws ExceptionService {
        try {
            return ofertasDAO.verificarOferta(oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de verificar una oferta" + e.toString());
        }
    }

    @Override
    public List<Ofertas> ofertasporUsuario(int solicitanteId) throws ExceptionService {
        try {
            return ofertasDAO.ofertasporUsuario(solicitanteId);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de verificar las ofertas por usuario" + e.toString());
        }
    }

    @Override
    public void actualizarEstadoOferta(int solicitanteId,String nombre, String estado) throws ExceptionService {
        try {
            ofertasDAO.actualizarEstadoOferta(solicitanteId,nombre,estado);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar el estado de la oferta" ,e);
        }
        
    }

    @Override
    public List<Ofertas> consultarOfertas() throws ExceptionService {
        try {
            return ofertasDAO.consultarOfertas();
        } catch (Exception e) {
            throw new ExceptionService(e.getMessage());
        }
    }
    
}
