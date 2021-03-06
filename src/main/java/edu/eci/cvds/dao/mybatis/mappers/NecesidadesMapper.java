package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesMapper {

   /**
     * Se agrega la necesidad deseada
     * @param need necesidad que se desea agregar
     * @throws PersistenceException
     */
    void agregarNecesidades(@Param("necesidad")Necesidad nece) throws PersistenceException;

    /**
     * Devuelve la necesidad que se identifica por el nombre deseado
     * @param nombre
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultar (@Param("name")String name)throws PersistenceException;

    /**
     * Devuelve la cantidad de necesidades asociadas a un id
     * @param id
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultarNecesidadesAsociadas (@Param("solicitante")int name)throws PersistenceException;

    /**
     * Actualiza el estado de la necesidad que se desea
     * @param nombre nombre de la necesidad
     * @param estado nuevo estado
     * @throws PersistenceException
     */
    void actualizarEstadoNecesidad(@Param("solicitante") int idsolicitante,@Param("nombre") String nombre, @Param("estado") String estado)throws PersistenceException;

    /**
     * Devuelve la cantidad de necesidades 
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultarNecesidades ()throws PersistenceException;

 /**
     * consulta cantidad de ofertas por la categoria seleccionada
     * @param categoria     id categoria a consultar
     * @return
     */
    List<Necesidad> consultarNecesidadCategorias(@Param("categoria") int categoria )throws PersistenceException;
    
}