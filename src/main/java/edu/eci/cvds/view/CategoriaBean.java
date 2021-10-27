package edu.eci.cvds.view;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.SolidaridadServices;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Date;

@javax.faces.bean.ManagedBean(name = "categoriaBean")
@SessionScoped
public class CategoriaBean  {

    @Inject
    private SolidaridadServices solidaridadServices;
    private Categoria categoria;
    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private String oldnombre;

    public void registrar(){
        solidaridadServices.registrarCategoria(categoria);
    }

    public void actualizarCategoria() throws PersistenceException{
        try {
            solidaridadServices.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (Exception e) {
            throw new PersistenceException("Se produjo un error a la hora de actualizar la categoria", e);
        }

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
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

    public String getOldnombre() {
        return oldnombre;
    }

    public SolidaridadServices getSolidaridadServices() {
        return solidaridadServices;
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

    public void setOldnombre(String oldnombre) {
        this.oldnombre = oldnombre;
    }

    public void setSolidaridadServices(SolidaridadServices solidaridadServices) {
        this.solidaridadServices = solidaridadServices;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
