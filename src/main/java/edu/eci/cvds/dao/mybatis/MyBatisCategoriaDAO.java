package edu.eci.cvds.dao.mybatis;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.ExceptionService;

import java.util.List;

import javax.inject.Inject;

public class MyBatisCategoriaDAO implements CategoriaDAO {
    
    @Inject
    CategoriaMapper categoriaMapper;

    @Override
    public void registrarCategoria(Categoria categoria) throws ExceptionService{
        try {
            categoriaMapper.registrarCategoria(categoria);
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

    @Override
    public List<Categoria> verificarCategoria(String oldnombre) throws ExceptionService {
        try {
            return categoriaMapper.verificarCategoria(oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de verificar si existe la categoria", e);
        }
    }

    @Override
    public List<Categoria> consultarCategorias() throws ExceptionService {
        try {
            return categoriaMapper.consultarCategorias();
        } catch (Exception e){
            throw new ExceptionService("No se encuentran las categorias", e);
        }
    }

    @Override
    public Categoria consultarCategoria(int cId) throws ExceptionService {
        try {
            return categoriaMapper.consultarCategoria(cId);
        } catch (Exception e){
            throw new ExceptionService("No se encuentra la categoria", e);
        }
    }

    @Override
    public void eliminarCategoria(String nombre) throws ExceptionService {
        try {
            categoriaMapper.eliminarCategoria(nombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de eliminar la categoria", e);
        }
        
    }


}
