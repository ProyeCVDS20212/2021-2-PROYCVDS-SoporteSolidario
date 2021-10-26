package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Categoria;
import org.apache.ibatis.annotations.Param;

public interface CategoriaMapper {
    public void añadirCategoria(@Param("categoria") Categoria categoria);

    public void actualizarCategoria(@Param("newNombre")String nombre, 
    @Param("newDescripcion")String descripcion, @Param("newEstado")boolean estado, @Param("oldNombre")String oldnombre);
}
