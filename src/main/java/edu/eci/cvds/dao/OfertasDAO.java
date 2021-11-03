package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;

public interface OfertasDAO {

    void agregarOferta(Ofertas oferta) throws ExceptionService;

    
}
