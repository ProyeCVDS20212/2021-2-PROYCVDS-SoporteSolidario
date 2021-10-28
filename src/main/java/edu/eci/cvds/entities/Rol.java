package edu.eci.cvds.entities;

import java.math.BigDecimal;

public class Rol {
    private int id;
    private String nombre;
    private int limiteSolicitudes;


    public Rol(BigDecimal id,String nombre,BigDecimal limite){
        this.id = id.intValue();
        this.nombre = nombre;
        this.limiteSolicitudes = limite.intValue();
    }

    public int getId() {
        return id;
    }
    public int getLimiteSolicitudes() {
        return limiteSolicitudes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLimiteSolicitudes(int limiteSolicitudes) {
        this.limiteSolicitudes = limiteSolicitudes;
    }public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
