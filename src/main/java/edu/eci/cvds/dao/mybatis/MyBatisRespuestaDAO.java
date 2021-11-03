package edu.eci.cvds.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.RespuestaDAO;
import edu.eci.cvds.dao.mybatis.mappers.RespuestasMapper;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.ExceptionService;

public class MyBatisRespuestaDAO implements RespuestaDAO{
    @Inject
    RespuestasMapper respuestasMapper;

    @Override
    public List<Respuesta> consultarRespuestas() throws ExceptionService {
        try {
            return respuestasMapper.consultarRespuestas();
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de consultar respuestas", e);
        }
    }

    @Override
    public List<Respuesta> consultarRespuesta(int id) throws ExceptionService {
        try {
            return respuestasMapper.consultarRespuesta(id);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de consultar respuesta", e);
        }
    }

    @Override
    public void registrarRespuestaOferta(Respuesta respuesta) throws ExceptionService {
        try {
            respuestasMapper.registrarRespuestaOferta(respuesta);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar la respuesta", e);
        }
    }

    @Override
    public void registrarRespuestaNecesidad(Respuesta respuesta) throws ExceptionService {
        try {
            respuestasMapper.registrarRespuestaNecesidad(respuesta);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar la respuesta", e);
        }
    }
    
}
