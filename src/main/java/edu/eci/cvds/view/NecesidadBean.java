package edu.eci.cvds.view;

import java.sql.Date;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;

public class NecesidadBean extends BasePageBean{
    @Inject
    NecesidadesServices necesidadesServices;

    private int id;
    private String nombre;
    private String descripcion;
    private int urgencia;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int idsolicitante;

    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarNecesidades() throws ExceptionService {
        try {
            idsolicitante = CustomerServicesBean.getcustomerId();
            necesidadesServices.agregarNecesidades(new Necesidad(nombre,descripcion,true,categoriaId,urgencia,idsolicitante));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
public int getUrgencia() {
    return urgencia;
}
public Date getFechacreacion() {
    return fechacreacion;
}
public Date getFechamodificacion() {
    return fechamodificacion;
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
public void setCategoriaId(int categoriaId) {
    this.categoriaId = categoriaId;
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
public void setIdsolicitante(int idsolicitante) {
    this.idsolicitante = idsolicitante;
}

}