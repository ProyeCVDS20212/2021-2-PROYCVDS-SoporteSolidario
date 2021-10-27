package edu.eci.cvds.dao.mybatis;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.entities.Categoria;

import javax.inject.Inject;

public class MyBatisCategoriaDAO implements CategoriaDAO {
    
    @Inject
    CategoriaMapper categoriaMapper;

    @Override
    public void registrarCategoria(Categoria categoria)throws PersistenceException {
        categoriaMapper.anadirCategoria(categoria);
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
