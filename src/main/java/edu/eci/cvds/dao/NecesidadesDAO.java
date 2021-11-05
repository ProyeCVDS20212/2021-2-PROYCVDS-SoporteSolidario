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
    int consultarNecesidadesAsociadas(int name) throws PersistenceException;

    /**
     * Actualiza el estado de la necesidad que se desea
     * @param nombre nombre de la necesidad
     * @param estado nuevo estado
     * @throws PersistenceException
     */
    void actualizarEstadoNecesidad(String nombre, char estado) throws PersistenceException;

}
