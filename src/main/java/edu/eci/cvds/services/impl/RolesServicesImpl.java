package edu.eci.cvds.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.services.RolesServices;

public class RolesServicesImpl implements RolesServices{

    @Inject
    RolesDAO rolesDAO;

    @Override
    public int limiteNecesidades(int id) throws PersistenceException {
        return rolesDAO.limiteNecesidades(id);
    }

    @Override
    public int limiteOfertas(int id) throws PersistenceException {
        return rolesDAO.limiteOfertas(id);
    }

    @Override
    public String getRol(int id) throws PersistenceException {
        return rolesDAO.getRol(id);
    }
    
}
