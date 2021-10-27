package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categoria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoriaMapper {

    
    public void registrarCategoria(@Param("categoria") Categoria categoria);

    public void  actualizarCategoria(@Param("newNombre")String nombre,@Param("newDescripcion")String descripcion, @Param("newEstado")boolean estado, @Param("oldNombre")String oldnombre);

    public List<Categoria> verificarCategoria(@Param("oldnombre")String oldnombre);
}
