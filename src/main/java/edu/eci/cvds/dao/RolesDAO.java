package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Rol;

public interface RolesDAO {
    int limiteNecesidades(int id) throws PersistenceException;
    int limiteOfertas(int id) throws PersistenceException;
    String getRol(int id) throws PersistenceException;
}
