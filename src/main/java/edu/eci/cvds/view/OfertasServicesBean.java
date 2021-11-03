package edu.eci.cvds.view;

import java.sql.Date;
import java.util.Set;

import  javax.faces.bean.ManagedBean;
import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.OfertasServices;

@ManagedBean(name = "ofertasBean")
public class OfertasServicesBean  extends BasePageBean{
    @Inject
    OfertasServices ofertasServices;

    private int id;
    private String NOMBRE;
    private String descripcion;
    private boolean Estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int solicitanteId;




    public void agregarOferta() throws ExceptionService{
        try {
            solicitanteId = CustomerServicesBean.getcustomerId();
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de agregar una oferta" + e.toString());
        }

    }
    public int getCategoriaId() {
        return categoriaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return NOMBRE;
    }

    public int getSolicitanteId() {
        return solicitanteId;
    }
    
    public boolean getEstado(){
        return Estado;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.NOMBRE = nombre;
    }

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }
    
}
