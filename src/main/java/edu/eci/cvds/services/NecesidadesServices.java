package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesServices {
    void agregarNecesidades(Necesidad need) throws ExceptionService;
    int consultarNecesidadesAsociadas(int id)throws ExceptionService;
    List<Necesidad>  consultarnecesidad(String nombre) throws ExceptionService;
}
