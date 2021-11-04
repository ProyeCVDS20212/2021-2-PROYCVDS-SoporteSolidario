package edu.eci.cvds.services;

import edu.eci.cvds.entities.Necesidad;

public interface NecesidadesServices {
    void agregarNecesidades(Necesidad need) throws ExceptionService;
    int consultarNecesidadesAsociadas(int id,boolean estado)throws ExceptionService;
}
