package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Rol;

public interface RolesServices {
    public int limiteNecesidades(int id) throws PersistenceException;
    public int limiteOfertas(int id)throws PersistenceException;
    public String getRol(int id)throws PersistenceException;
}
