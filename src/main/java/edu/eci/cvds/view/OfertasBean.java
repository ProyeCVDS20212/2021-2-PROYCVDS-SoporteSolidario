package edu.eci.cvds.view;

import java.sql.Date;
import java.util.Set;

import  javax.faces.bean.ManagedBean;
import com.google.inject.Inject;
import com.google.inject.Injector;

import edu.eci.cvds.services.ExceptionService;

@ManagedBean(name = "ofertasBean")
public class OfertasBean  extends BasePageBean{

    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechadecreacion;
    private Date fechamodificacion;
    private int categoriaid;




    public void agregarOferta() throws ExceptionService{

        try {
            
        } catch (Exception e) {
            
        }

    }
    
    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }
    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }
    public int getCategoriaid() {
        return categoriaid;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Date getFechadecreacion() {
        return fechadecreacion;
    }
    public Date getFechamodificacion() {
        return fechamodificacion;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}
