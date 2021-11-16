package edu.eci.cvds.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Ofertas implements Serializable{
    private int id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int solicitanteId;

    public Ofertas(String nombre, String descripcion, String estado, BigDecimal categoriaId, BigDecimal solicitanteId){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoriaId = categoriaId.intValue();
        this.solicitanteId = solicitanteId.intValue();
    }

    public Ofertas(String nombre, String descripcion, String estado, int categoriaId, int solicitanteId){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoriaId = categoriaId;
        this.solicitanteId = solicitanteId;
    }
    public Ofertas(){
        super();
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
        return nombre;
    }

    public int getSolicitanteId() {
        return solicitanteId;
    }
    
    public String getEstado(){
        return estado;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        this.nombre = nombre;
    }

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

}
