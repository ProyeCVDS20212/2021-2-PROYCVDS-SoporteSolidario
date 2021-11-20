package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesDAO {

    /**
     * Se agrega la necesidad deseada
     * @param need necesidad que se desea agregar
     * @throws PersistenceException
     */
    void agregarNecesidades(Necesidad need) throws PersistenceException;

    /**
     * Devuelve la necesidad que se identifica por el nombre deseado
     * @param nombre
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultar(String name) throws PersistenceException;

    /**
     * Devuelve la cantidad de necesidades asociadas a un id
     * @param id
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultarNecesidadesAsociadas(int name) throws PersistenceException;

    /**
     * Actualiza el estado de la necesidad que se desea
     * @param nombre nombre de la necesidad
     * @param estado nuevo estado
     * @param idsolicitante id del solicitante
     * @throws PersistenceException
     */
    void actualizarEstadoNecesidad(int idsolicitante,String nombre, String estado) throws PersistenceException;

    /**
     * Devuelve la cantidad de necesidades 
     * @param id
     * @return
     * @throws PersistenceException
     */
    List<Necesidad> consultarNecesidades() throws PersistenceException;


         /**
     * consulta cantidad de ofertas por la necesidad seleccionada
     * @param necesidad     id necesidad a consultar
     * @return
     */
    int consultarNecesidadCategorias(int necesidad)throws PersistenceException;
}
