package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categoria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoriaMapper {

    /**
     * Se registra la categoria
     * @param categoria categoria que se desea registrar
     */
    public void registrarCategoria(@Param("categoria") Categoria categoria);

    /**
     * Se actualiza la categoria
     * @param nombre nombre nuevo para la categoria
     * @param descripcion descripcion nueva para la categoria
     * @param estado estado nuevo para la categoria
     * @param oldnombre nombre de la categoria que se desea actualizar
     */
    public void  actualizarCategoria(@Param("newNombre")String nombre,@Param("newDescripcion")String descripcion, @Param("newEstado")boolean estado, @Param("oldNombre")String oldnombre);

    /**
     * Verifica si ya existe esa categoria en la base de datos
     * @param oldnombre nombre de la categoria que se desea consultar
     * @return
     */
    public List<Categoria> verificarCategoria(@Param("oldnombre")String oldnombre);

    /**
     * Retorna todas las categorias que existen 
     * @return
     */
    public List<Categoria> consultarCategorias();
    
    /**
     * Retorna todas las categorias que existen 
     * @return
     */
    public List<Categoria> consultarCategoriasV();

    /**
     * Devuelve la categoria deseada dependiendo del id
     * @param cId id de la categoria que se desea retornar
     * @return
     */
    public Categoria consultarCategoria(@Param("categoriaId")int cId);

    /**
     * Elimina la categoria seleccionada dependiendo del nombre
     * @param nombre nombre de la categoria que se desea eliminar
     */
    public void eliminarCategoria(@Param("dnombre") String nombre);
}
