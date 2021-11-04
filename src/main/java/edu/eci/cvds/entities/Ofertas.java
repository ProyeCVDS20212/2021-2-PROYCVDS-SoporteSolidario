package edu.eci.cvds.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Ofertas implements Serializable{
    private int id;
    private String NOMBRE;
    private String descripcion;
    private boolean Estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int solicitanteId;

    public Ofertas(String nombre, String descripcion, boolean estado, BigDecimal categoriaId, BigDecimal solicitanteId){
        this.NOMBRE = nombre;
        this.descripcion = descripcion;
        this.Estado = estado;
        this.categoriaId = categoriaId.intValue();
        this.solicitanteId = solicitanteId.intValue();
    }

    public Ofertas(String nombre, String descripcion, boolean estado, int categoriaId, int solicitanteId){
        this.NOMBRE = nombre;
        this.descripcion = descripcion;
        this.Estado = estado;
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
