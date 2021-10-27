package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaDAO {

    public void registrarCategoria(Categoria categoria) throws PersistenceException;

    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws PersistenceException;
}
