package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;

public interface OfertasMapper {
    
    /**
     * Agrega la oferta deseada
     * @param oferta
     * @throws ExceptionService
     */
    void agregarOferta(@Param("oferta") Ofertas oferta) throws ExceptionService;

    /**
     * Returna la lista de ofertas que tiene el nombre que se desea buscar
     * @param oldnombre
     * @return
     * @throws ExceptionService
     */
    List<Ofertas> verificarOferta(@Param("oldnombre") String oldnombre);


    /**
     * Se retorna la lista de ofertas que tiene el usuario con el id especifico
     * @param solicitanteId
     * @return
     * @throws ExceptionService
     */
    List<Ofertas> ofertasporUsuario(@Param("solicitanteId") int solicitanteId);

 /**
     * Se retorna la lista de ofertas
     * @return
     * @throws ExceptionService
     */
    List<Ofertas> consultarOfertas();



    /**
     * Se actualiza el estado de la oferta deseada
     * @param nombre nombre de la oferta que se desea actualizar el estado
     * @param estado nuevo estado de la oferta
     */
    void actualizarEstadoOferta(@Param("solicitanteId")int solicitanteId,@Param("nombre")String nombre, @Param("estado")String estado);

}
