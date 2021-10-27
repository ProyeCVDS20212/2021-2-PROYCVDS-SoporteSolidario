package edu.eci.cvds.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.CategoriaServices;
import edu.eci.cvds.services.ExceptionService;

public class CategoriaServicesImpl implements CategoriaServices {

    @Inject
    CategoriaDAO categoriaDAO;

    @Override
    public void registrarCategoria(Categoria categoria) throws ExceptionService{
        try {
            categoriaDAO.registrarCategoria(categoria);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar una categoria", e);
        }

    }

    @Override
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService {
        try {
            categoriaDAO.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar una categoria", e);
        }
        
    }
}
