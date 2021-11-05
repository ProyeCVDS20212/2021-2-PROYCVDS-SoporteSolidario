package edu.eci.cvds.entities;

import java.math.BigDecimal;

public class Rol {
    private int id;
    private String nombre;
    private int limiteSolicitudes;
    private int limiteOfertas;

    public Rol(BigDecimal id,String nombre,BigDecimal limite){
        this.id = id.intValue();
        this.nombre = nombre;
        this.limiteSolicitudes = limite.intValue();
    }
    public Rol(BigDecimal id,String nombre,BigDecimal limite,BigDecimal limiteo){
        this.id = id.intValue();
        this.nombre = nombre;
        this.limiteSolicitudes = limite.intValue();
        this.limiteOfertas = limiteo.intValue();
    }

    public int getId() {
        return id;
    }
    public int getLimiteSolicitudes() {
        return limiteSolicitudes;
    }
    public int getLimiteOfertas() {
        return limiteOfertas;
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
    public void setLimiteOfertas(int limiteOfertas) {
        this.limiteOfertas = limiteOfertas;
    }
}
