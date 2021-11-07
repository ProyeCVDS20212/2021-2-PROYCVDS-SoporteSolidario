package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

public interface RolesServices {
    public int limiteNecesidades(int id) throws PersistenceException;
    public int limiteOfertas(int id)throws PersistenceException;
    public int limiteNecesidades(String id) throws PersistenceException;
    public int limiteOfertas(String id)throws PersistenceException;
    public String getRol(int id)throws PersistenceException;
    public void actualizarLimites(String rol,int limiteO , int limiteN)throws PersistenceException;
}
