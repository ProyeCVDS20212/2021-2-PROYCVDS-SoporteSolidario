package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesDAO {

    void agregarNecesidades(Necesidad need) throws PersistenceException;

    List<Necesidad> consultar(String name) throws PersistenceException;

    int consultarNecesidadesAsociadas(int name) throws PersistenceException;

    void actualizarEstadoNecesidad(String nombre, char estado) throws PersistenceException;

}
