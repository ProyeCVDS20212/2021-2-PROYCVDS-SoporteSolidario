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

    public Respuesta(BigDecimal id,String nombre,String comentario, Date fechacreacion,BigDecimal ofertaid,BigDecimal necesidad){
        this.id =id.intValue();
        this.nombre = nombre;
        this.comentario = comentario;
        this.fechacreacion = fechacreacion;
        this.ofertaid = ofertaid.intValue();
        this.necesidadid = necesidad.intValue();
    }

    public Respuesta(String nombre,String comentario,BigDecimal ofertaid,BigDecimal necesidad){
        this.nombre = nombre;
        this.comentario = comentario;
        this.ofertaid = ofertaid.intValue();
        this.necesidadid = necesidad.intValue();
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
