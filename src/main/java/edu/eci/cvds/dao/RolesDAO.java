package edu.eci.cvds.dao;


public interface RolesDAO {
    int limiteNecesidades(int id) throws PersistenceException;
    int limiteOfertas(int id) throws PersistenceException;
    int limiteNecesidades(String id) throws PersistenceException;
    int limiteOfertas(String id) throws PersistenceException;
    String getRol(int id) throws PersistenceException;
    void actualizarLimites(String rol, int limiteO, int limiteN) throws PersistenceException;
}
