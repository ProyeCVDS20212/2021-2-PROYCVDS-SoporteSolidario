package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Respuesta;

public interface RespuestaServices {
    public List<Respuesta> consultarRespuestas() throws ExceptionService;

    public List<Respuesta> consultarRespuesta(int id) throws ExceptionService;

    public void registrarRespuestaOferta(Respuesta respuesta) throws ExceptionService;
    
    public void registrarRespuestaNecesidad(Respuesta respuesta) throws ExceptionService;
}

