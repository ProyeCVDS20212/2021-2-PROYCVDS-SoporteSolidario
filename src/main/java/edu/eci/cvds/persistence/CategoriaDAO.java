package edu.eci.cvds.persistence;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categoria;

public interface CategoriaDAO {

    public void registrarCategoria(Categoria categoria);

    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws PersistenceException;
}
