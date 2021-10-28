package edu.eci.cvds.entities;

import java.math.BigDecimal;
import java.sql.Date;


public class Necesidad {
    private int id;
    private String nombre;
    private String descripcion;
    private int urgencia;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int idsolicitante;


    public Necesidad(BigDecimal id,String value, String description, boolean status, BigDecimal category_id, BigDecimal urgencia, BigDecimal idsolicitante){
        this.id = id.intValue();
        this.nombre = value;
        this.descripcion = description;
        this.urgencia = urgencia.intValue();
        this.estado = status;
        this.categoriaId = category_id.intValue();
        this.urgencia = urgencia.intValue();
        this.idsolicitante=idsolicitante.intValue();
    }

    public Necesidad(String value, String description, boolean status, BigDecimal category_id, BigDecimal urgencia, BigDecimal idsolicitante){
        this.nombre = value;
        this.descripcion = description;
        this.urgencia = urgencia.intValue();
        this.estado = status;
        this.categoriaId = category_id.intValue();
        this.urgencia = urgencia.intValue();
        this.idsolicitante=idsolicitante.intValue();
    }
    public Necesidad(String value, String description, boolean status, int category_id, int urgencia, int idsolicitante){
        this.nombre = value;
        this.descripcion = description;
        this.urgencia = urgencia;
        this.estado = status;
        this.categoriaId = category_id;
        this.urgencia = urgencia;
        this.idsolicitante=idsolicitante;
    }

    public int getCategoriaId() {
        return categoriaId;
    }
    public int getIdsolicitante() {
        return idsolicitante;
    }
    public boolean getEstado(){
        return estado;
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
    public int getUrgencia() {
        return urgencia;
    }
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setEstado(boolean estado) {
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
    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }



}
