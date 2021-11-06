package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesServices {
    /**
     * Se agrega la necesidad deseada
     * @param need necesidad que se desea agregar
     * @throws ExceptionService
     */
    void agregarNecesidades(Necesidad need) throws ExceptionService;

    /**
     * Devuelve  necesidades asociadas a un id
     * @param id
     * @return
     * @throws ExceptionService
     */
    List<Necesidad> consultarNecesidadesAsociadas(int solicitante) throws ExceptionService;

    /**
     * Devuelve la cantidad de necesidades asociadas a un id y estan activas
     * @param id
     * @return
     * @throws ExceptionService
     */
    int consultarNecesidadesAsociadasA(int id)throws ExceptionService;

    /**
     * Devuelve la necesidad que se identifica por el nombre deseado
     * @param nombre
     * @return
     * @throws ExceptionService
     */
    List<Necesidad>  consultarnecesidad(String nombre) throws ExceptionService;

    /**
     * Actualiza el estado de la necesidad que se desea
     * @param nombre nombre de la necesidad
     * @param estado nuevo estado
     * @throws ExceptionService
     */
    void actualizarEstadoNecesidad(int idsolicitante,String nombre, String estado) throws ExceptionService;

}
