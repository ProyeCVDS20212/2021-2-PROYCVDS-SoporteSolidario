package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Respuesta;

public interface RespuestasMapper {
    public List<Respuesta> consultarRespuestas();
    public List<Respuesta> consultarRespuesta(@Param("id")int id);
    public void registrarRespuestaOferta(@Param("respuesta")Respuesta respuesta);
    public void registrarRespuestaNecesidad(@Param("respuesta")Respuesta respuesta);
}
