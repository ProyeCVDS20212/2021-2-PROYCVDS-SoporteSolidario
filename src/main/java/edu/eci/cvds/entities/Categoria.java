package edu.eci.cvds.entities;

import java.util.Date;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechacreacion;
    private boolean estado;
    private Date fechamodificacion;
    private boolean esValido;
    private String descripcioninvalida;


    public Categoria(int id, String nombre, String descripcion, Date fechacreacion, boolean estado, Date fechamodificacion, boolean esValido, String descripcioninvalida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
        this.fechamodificacion = fechamodificacion;
        this.esValido = esValido;
        this.descripcioninvalida = descripcioninvalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public boolean isEsValido() {
        return esValido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    public String getDescripcioninvalida() {
        return descripcioninvalida;
    }

    public void setDescripcioninvalida(String descripcioninvalida) {
        this.descripcioninvalida = descripcioninvalida;
    }
}