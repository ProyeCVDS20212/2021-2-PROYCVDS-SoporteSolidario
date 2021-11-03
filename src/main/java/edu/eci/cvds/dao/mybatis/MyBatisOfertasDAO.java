package edu.eci.cvds.dao.mybatis;

import java.util.List;

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

    @Override
    public List<Ofertas> verificarOferta(String oldnombre) throws ExceptionService {
        try {
            return ofertaMapper.verificarOferta(oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de verrificar la oferta" + e.toString());
        }
    }

    @Override
    public List<Ofertas> OfertasporUsuario(int solicitanteId) throws ExceptionService {
        try {
            return ofertaMapper.OfertasporUsuario(solicitanteId);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de ver las ofertas por usuario" + e.toString());
        }
    }
    
}
