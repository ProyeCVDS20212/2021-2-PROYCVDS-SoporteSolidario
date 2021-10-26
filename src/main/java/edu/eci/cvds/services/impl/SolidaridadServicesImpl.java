package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.SolidaridadServices;

public class SolidaridadServicesImpl implements SolidaridadServices {

    @Inject
    private CategoriaDAO categoriaDAO;

    @Override
    public void registrarCategoria(Categoria categoria){
        categoriaDAO.registrarCategoria(categoria);

    }

    @Override
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws PersistenceException {
        try {
            categoriaDAO.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (Exception e) {
            throw new PersistenceException("Se produjo un error a la hora de actualizar una categoria", e);
        }
        
    }
}
