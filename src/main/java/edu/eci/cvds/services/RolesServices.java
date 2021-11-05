package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

public interface RolesServices {
    public int limiteNecesidades(int id) throws PersistenceException;
    public int limiteOfertas(int id)throws PersistenceException;
}
