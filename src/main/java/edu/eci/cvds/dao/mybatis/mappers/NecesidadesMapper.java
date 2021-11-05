package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesMapper {
    void agregarNecesidades(@Param("necesidad")Necesidad nece) throws PersistenceException;
    List<Necesidad> consultar (@Param("name")String name)throws PersistenceException;
    List<Necesidad> consultarNecesidadesAsociadas (@Param("solicitante")int name)throws PersistenceException;

}