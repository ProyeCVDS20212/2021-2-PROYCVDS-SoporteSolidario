package edu.eci.cvds.services;


import edu.eci.cvds.entities.Categoria;

public interface CategoriaServices{

    /**
     * 
     * @param c
     * @throws ExceptionService
     */
    public void registrarCategoria(Categoria c)throws ExceptionService;

    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService;
}
