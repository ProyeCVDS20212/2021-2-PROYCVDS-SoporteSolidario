package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;

public interface OfertasDAO {

    /**
     * Agrega la oferta deseada
     * @param oferta
     * @throws ExceptionService
     */
    void agregarOferta(Ofertas oferta) throws ExceptionService;

    /**
     * Returna la lista de ofertas que tiene el nombre que se desea buscar
     * @param oldnombre
     * @return
     * @throws ExceptionService
     */
    List<Ofertas> verificarOferta(String oldnombre) throws ExceptionService;

    /**
     * Se retorna la lista de ofertas que tiene el usuario con el id especifico
     * @param solicitanteId
     * @return
     * @throws ExceptionService
     */
    List<Ofertas> OfertasporUsuario(int solicitanteId) throws ExceptionService;

    /**
     * Se actualiza el estado de la oferta deseada
     * @param nombre nombre de la oferta que se desea actualizar el estado
     * @param estado nuevo estado de la oferta
     * @throws ExceptionService
     */
    void actualizarEstadoOferta(String nombre, char estado) throws ExceptionService;

}
