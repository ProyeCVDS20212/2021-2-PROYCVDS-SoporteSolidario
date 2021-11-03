package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.ExceptionService;

public interface RespuestaDAO {
    public List<Respuesta> consultarRespuestas() throws ExceptionService;
    public List<Respuesta> consultarRespuesta(int id) throws ExceptionService;
    public void registrarRespuestaOferta(Respuesta respuesta) throws ExceptionService;
    public void registrarRespuestaNecesidad(Respuesta respuesta) throws ExceptionService;

}
