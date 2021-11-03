package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;

public interface OfertasMapper {
    void agregarOferta(@Param("oferta") Ofertas oferta) throws ExceptionService;
    
}
