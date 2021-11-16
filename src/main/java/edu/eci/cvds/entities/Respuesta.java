package edu.eci.cvds.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Respuesta {
    
    private int id ;
    private String nombre;
    private String comentario;
    private Date fechacreacion;
    private int ofertaid;
    private int necesidadid;
    private int remitente;

    public Respuesta(BigDecimal id,String nombre,String comentario, Date fechacreacion,BigDecimal ofertaid,BigDecimal necesidad,BigDecimal remite){
        this.id =id.intValue();
        this.nombre = nombre;
        this.comentario = comentario;
        this.fechacreacion = fechacreacion;
        this.ofertaid = ofertaid != null? ofertaid.intValue():0;
        this.necesidadid = necesidad != null? necesidad.intValue():0;
        this.remitente = remite.intValue();
    }
    public Respuesta(BigDecimal id,String nombre,String comentario, Date fechacreacion,String ofertaid,BigDecimal necesidad,BigDecimal remite){
        this.id =id.intValue();
        this.nombre = nombre;
        this.comentario = comentario;
        this.fechacreacion = fechacreacion;
        this.necesidadid = necesidad.intValue();
        this.remitente = remite.intValue();
    }

    public Respuesta(String nombre,String comentario,int ofertaid,int necesidad,int remi){
        this.nombre = nombre;
        this.comentario = comentario;
        this.ofertaid = ofertaid;
        this.necesidadid = necesidad;
        this.remitente = remi;
    }
    public void setRemitente(int remitente) {
        this.remitente = remitente;
    }

    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNecesidadid(int necesidadid) {
        this.necesidadid = necesidadid;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setOfertaid(int ofertaid) {
        this.ofertaid = ofertaid;
    }
    public String getComentario() {
        return comentario;
    }
    public int getRemitente() {
        return remitente;
    }
    public Date getFechacreacion() {
        return fechacreacion;
    }
    public int getId() {
        return id;
    }
    public int getNecesidadid() {
        return necesidadid;
    }
    public String getNombre() {
        return nombre;
    }
    public int getOfertaid() {
        return ofertaid;
    }
}
