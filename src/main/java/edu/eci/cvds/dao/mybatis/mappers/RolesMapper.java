package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Rol;

public interface RolesMapper {
    
    List<Rol> consultarRol(@Param("id")int id);

}
