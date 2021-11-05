package edu.eci.cvds.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Respuesta;

public interface RespuestasMapper {

    /**
     * Devuelve una lista con las respuestas existentes
     * @return
     */
    public List<Respuesta> consultarRespuestas();

    /**
     * Devuelve las respuestas que se desean consultar
     * @param id respuesta que se desea consultar
     * @return
     */
    public List<Respuesta> consultarRespuesta(@Param("id")int id);

    /**
     * Registra una respuesta a una oferta
     * @param respuesta respuesta que se desea registrar
     */
    public void registrarRespuestaOferta(@Param("respuesta")Respuesta respuesta);

    /**
     * Registra una respuesta a una necesidad
     * @param respuesta respuesta que se desea registrar
     */
    public void registrarRespuestaNecesidad(@Param("respuesta")Respuesta respuesta);
}
