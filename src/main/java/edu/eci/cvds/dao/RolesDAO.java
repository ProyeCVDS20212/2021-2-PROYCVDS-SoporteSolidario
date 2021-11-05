package edu.eci.cvds.dao;

public interface RolesDAO {
    int limiteNecesidades(int id) throws PersistenceException;
    int limiteOfertas(int id) throws PersistenceException;
}
