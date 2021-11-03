package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.dao.OfertasDAO;
import edu.eci.cvds.dao.mybatis.mappers.OfertasMapper;
import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;

public class MyBatisOfertasDAO implements OfertasDAO{
    @Inject
    OfertasMapper ofertaMapper;

    @Override
    public void agregarOferta(Ofertas oferta) throws ExceptionService {
        try {
            ofertaMapper.agregarOferta(oferta);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar una nueva oferta" + e.toString());
        }
        
    }
    
}
