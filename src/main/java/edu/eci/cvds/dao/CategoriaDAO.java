package edu.eci.cvds.dao;

import java.util.List;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.ExceptionService;

public interface CategoriaDAO {

    /**
     * Se registra la categoria
     * @param categoria categoria que se desea registrar
     * @throws ExceptionService
     */
    public void registrarCategoria(Categoria categoria) throws ExceptionService;

    /**
     * 
     * Se actualiza la categoria
     * @param nombre nombre nuevo para la categoria
     * @param descripcion descripcion nueva para la categoria
     * @param estado estado nuevo para la categoria
     * @param oldnombre nombre de la categoria que se desea actualizar
     * @throws ExceptionService
     */
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService;

    /**
     * 
      * Verifica si ya existe esa categoria en la base de datos
     * @param oldnombre nombre de la categoria que se desea consultar
     * @return
     * @throws ExceptionService
     */
    List<Categoria> verificarCategoria(String oldnombre) throws ExceptionService;

    /**
    * Retorna todas las categorias que existen 
     * @return
     * @throws ExceptionService
     */
    List<Categoria> consultarCategorias() throws ExceptionService;

    /**
     * 
     * Devuelve la categoria deseada dependiendo del id
     * @param cId id de la categoria que se desea retornar
     * @return
     * @throws ExceptionService
     */
    Categoria consultarCategoria(int cId) throws ExceptionService;

    /**
     * Elimina la categoria seleccionada dependiendo del nombre
     * @param nombre nombre de la categoria que se desea eliminar
     * @throws ExceptionService
     */
    void eliminarCategoria(String nombre) throws ExceptionService;



}
