package edu.eci.cvds.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.RespuestaDAO;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.RespuestaServices;

public class RespuestaServicesImpl implements RespuestaServices{
    @Inject
    RespuestaDAO respuestaDAO;

    @Override
    public List<Respuesta> consultarRespuestas() throws ExceptionService {
        try {
            return respuestaDAO.consultarRespuestas();
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de consultar respuestas", e);
        }
    }

    @Override
    public List<Respuesta> consultarRespuesta(int id) throws ExceptionService {
        try {
            return respuestaDAO.consultarRespuesta(id);
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de consultar respuesta", e);
        }
    }

    @Override
    public void registrarRespuestaOferta(Respuesta respuesta) throws ExceptionService {
        try {
            respuestaDAO.registrarRespuestaOferta(respuesta);
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar la respuesta", e);
        }
    }

    @Override
    public void registrarRespuestaNecesidad(Respuesta respuesta) throws ExceptionService {
        try {
            respuestaDAO.registrarRespuestaNecesidad(respuesta);
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar la respuesta", e);
        }
    }
}
