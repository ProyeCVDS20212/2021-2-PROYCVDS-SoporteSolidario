package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.ExceptionService;

public interface RespuestaDAO {
    /**
     * Devuelve una lista con las respuestas existentes
     * @return
     * @throws ExceptionService
     */
    public List<Respuesta> consultarRespuestas() throws ExceptionService;

    /**
     * Devuelve las respuestas que se desean consultar
     * @param id respuesta que se desea consultar
     * @return
     * @throws ExceptionService
     */
    public List<Respuesta> consultarRespuesta(int id) throws ExceptionService;

    /**
     * Registra una respuesta a una oferta
     * @param respuesta respuesta que se desea registrar
     * @throws ExceptionService
     */
    public void registrarRespuestaOferta(Respuesta respuesta) throws ExceptionService;

    /**
     * Registra una respuesta a una necesidad
     * @param respuesta respuesta que se desea registrar
     * @throws ExceptionService
     */
    public void registrarRespuestaNecesidad(Respuesta respuesta) throws ExceptionService;

}
