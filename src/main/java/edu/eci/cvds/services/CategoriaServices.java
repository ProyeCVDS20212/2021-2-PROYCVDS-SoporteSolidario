package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Categoria;

public interface CategoriaServices{

    /**
     * Metodo usado por CategoriaServicesBean para enviar registrarCategoria a CategoriaServicesImpl
     * @param c categoria que se desea registrar
     * @throws ExceptionService 
     */
    public void registrarCategoria(Categoria c)throws ExceptionService;

    /**
     * Metodo usado por CategoriaServicesBean para enviar actualizarCategoria a CategoriaServicesImpl
     * @param nombre nombre que se le desea poner a la categoria
     * @param descripcion descpricion de la categoria
     * @param estado estado de la categoria
     * @param oldnombre nombre que tiene la categoria que se desea actualizar
     * @throws ExceptionService
     */
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService;


    /***
     * Verifica si la categoria que se desea buscar existe en la base de datos
     * @param oldnombre nombre de la categoria
     * @return
     * @throws ExceptionService
     */
    public List<Categoria> verificarCategoria(String oldnombre) throws ExceptionService;

    List<Categoria> consultarCategorias() throws ExceptionService;

    Categoria consultarCategoria(int cId) throws ExceptionService;
}
