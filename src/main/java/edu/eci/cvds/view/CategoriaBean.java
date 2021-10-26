package edu.eci.cvds.view;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.SolidaridadServices;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.Date;

@javax.faces.bean.ManagedBean(name = "categoriaBean")
@SessionScoped
public class CategoriaBean extends PageBean{

    @Inject
    private SolidaridadServices solidaridadServices;
    private Categoria categoria;
    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;

    public void registrar(){
        solidaridadServices.registrarCategoria(categoria);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
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
