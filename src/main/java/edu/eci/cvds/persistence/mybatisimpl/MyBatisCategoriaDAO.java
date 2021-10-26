package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.CategoriaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.CategoriaMapper;


import javax.inject.Inject;

public class MyBatisCategoriaDAO implements CategoriaDAO {

    @Inject
    private CategoriaMapper categoriaMapper;

    @Override
    public void registrarCategoria(Categoria categoria) {
        categoriaMapper.añadirCategoria(categoria);
    }

    @Override
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws PersistenceException {
        try {
            categoriaMapper.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (Exception e) {
            throw new PersistenceException("Se produjo un error a la hora de actualizar la categoria", e);
        }
        
    }
}
