package edu.eci.cvds.view;

import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.services.CategoriaServices;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;
import edu.eci.cvds.services.RolesServices;

@javax.faces.bean.ManagedBean(name = "necesidadBean")
@SessionScoped
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
    private char estado;
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
            if(rolesServices.limiteNecesidades(CustomerServicesBean.getRol()) > necesidadesServices.consultarNecesidadesAsociadas(idsolicitante)){
                necesidadesServices.agregarNecesidades(new Necesidad(nombre, descripcion, 'A', categoriaId, urgencia, idsolicitante));
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necesidad Creada de forma exitosa", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                clear();
            }else
            {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se supera el limite de necesidades",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de agregar una necesidad " + e.getMessage());
        }
    }

    public void actualizarEstadoNecesidad() throws ExceptionService{
        try {
            
        } catch (Exception e) {
            
        }
    }



    public void clear(){
        id = 0;
        nombre= null;
        descripcion= null;
        urgencia= 0;
        estado = 'A';
        fechacreacion= null;
        fechamodificacion= null;
        categoriaId= 0;
        idsolicitante= 0;
        categoria= null;
    }

    public List<Categoria> getCategorias() throws ExceptionService{
        return categoriaServices.consultarCategorias();
    };
    public Categoria getC(int cId) throws ExceptionService{
        return categoriaServices.consultarCategoria(cId);
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
public char getEstado(){
    return estado;
}
public void setCategoriaId(int categoriaId) {
    this.categoriaId = categoriaId;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public void setEstado(char estado) {
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