package edu.eci.cvds.dao.mybatis;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.ExceptionService;

import javax.inject.Inject;

public class MyBatisCategoriaDAO implements CategoriaDAO {
    
    @Inject
    CategoriaMapper categoriaMapper;

    @Override
    public void registrarCategoria(Categoria categoria) throws ExceptionService{
        try {
            categoriaMapper.anadirCategoria(categoria);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar la categoria", e);
        }
    }

    @Override
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService {
        try {
            categoriaMapper.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar la categoria", e);
        }
        
    }
}
