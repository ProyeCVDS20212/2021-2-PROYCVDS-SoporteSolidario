package edu.eci.cvds.view;

import java.sql.Date;

import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.eci.cvds.services.CustomerServices;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;

public class NecesidadBean extends BasePageBean{
    

    private int id;
    private String nombre;
    private String descripcion;
    private int urgencia;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private String categoriaId;
    private String idsolicitante;
    private int limiteNecesidades;

    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarNecesidades() throws ExceptionService {
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
public int getUrgencia() {
    return urgencia;
}
public Date getFechacreacion() {
    return fechacreacion;
}
public Date getFechamodificacion() {
    return fechamodificacion;
}
public String getCategoriaId() {
    return categoriaId;
}
public String getIdsolicitante() {
    return idsolicitante;
}
public boolean getEstado(){
    return estado;
}

}