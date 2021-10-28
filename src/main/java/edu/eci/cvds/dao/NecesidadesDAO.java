package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesDAO {

    void agregarNecesidades(Necesidad need) throws PersistenceException;

    List<Necesidad> consultar(String name) throws PersistenceException;
}
