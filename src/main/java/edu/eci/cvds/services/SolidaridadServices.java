package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categoria;

public interface SolidaridadServices {

    public void registrarCategoria(Categoria c)throws PersistenceException;

    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws PersistenceException;
}
