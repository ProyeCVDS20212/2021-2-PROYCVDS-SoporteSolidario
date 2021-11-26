package edu.eci.cvds.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechacreacion;
    private boolean estado;
    private Date fechamodificacion;
    private boolean esValido;
    private String descripcionInvalida;

    /**
     * Constructor para crear instancias de categoria sin necesidad de ningun atributo
     */
    public Categoria(){
        super();
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(boolean estado, boolean esValido){
        this.estado = estado;
        this.esValido = esValido;
    }

    public Categoria(BigDecimal id,String nombre,String descripcion,Date fechaa,boolean estado, Date fechab){
        this.id =id.intValue();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechacreacion = fechaa;
        this.estado = estado;
        this.fechamodificacion = fechab;
    }

    public Categoria(String nombre, String descripcion, Date fechacreacion, boolean estado, Date fechamodificacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.estado = estado;
        this.fechamodificacion = fechamodificacion;
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

    public boolean getisEstado() {
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

    public boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    public String getDescripcionInvalida() {
        return descripcionInvalida;
    }

    public void setDescripcionInvalida(String descripcionInvalida) {
        this.descripcionInvalida = descripcionInvalida;
    }
}