package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.ExceptionService;

public interface CategoriaDAO {

    public void registrarCategoria(Categoria categoria) throws ExceptionService;

    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService;

    List<Categoria> verificarCategoria(String oldnombre) throws ExceptionService;

    List<Categoria> consultarCategorias() throws ExceptionService;

    Categoria consultarCategoria(int cId) throws ExceptionService;
}
