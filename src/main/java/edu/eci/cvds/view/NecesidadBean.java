package edu.eci.cvds.view;

import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.services.CategoriaServices;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;
import edu.eci.cvds.services.RolesServices;

public class NecesidadBean extends BasePageBean{
    @Inject
    NecesidadesServices necesidadesServices;
    @Inject
    CategoriaServices categoriaServices;
    @Inject
    RolesServices rolesServices;
    private int id;
    private String nombre;
    private String descripcion;
    private int urgencia;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int idsolicitante;
    private String categoria;

    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarNecesidades() throws ExceptionService {
        try {
            idsolicitante = CustomerServicesBean.getcustomerId();
            try {
                List<Categoria> temp = categoriaServices.verificarCategoria(categoria.toUpperCase());
                if (temp.isEmpty())throw new ExceptionService("La categoria no existe");
                categoriaId = temp.get(0).getId();
            } catch (ExceptionService e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ""+e.getMessage(),
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            if(rolesServices.limiteNecesidades(id) > necesidadesServices.consultarNecesidadesAsociadas(idsolicitante,true)){
                necesidadesServices.agregarNecesidades(new Necesidad(nombre, descripcion, true, categoriaId, urgencia, idsolicitante));
            }else
            {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se supera el limite de necesidades",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de agregar una necesidad" + e.toString());
        }
    }
    public String getCategoria() {
        return categoria;
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
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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