package edu.eci.cvds.view;

import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import  javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.dao.NecesidadesDAO;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.CategoriaServices;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.OfertasServices;
import edu.eci.cvds.services.RolesServices;

@ManagedBean(name = "ofertasBean")
@SessionScoped
public class OfertasServicesBean  extends BasePageBean{
    @Inject
    OfertasServices ofertasServices;
    @Inject
    CategoriaServices categoriaServices;
    @Inject
    RolesServices rolesServices;

    private int id;
    private String nombre;
    private String descripcion;
    private String Estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private int categoriaId;
    private int solicitanteId;
    private String categoria;




    /**
     * Agrega la oferta deseada
     * @throws ExceptionService
     */
    public void agregarOferta() throws ExceptionService{
        try {
            solicitanteId = CustomerServicesBean.getcustomerId();
            try {
                List<Categoria> temp = categoriaServices.verificarCategoria(categoria.toUpperCase());
                if (temp.isEmpty())throw new ExceptionService("La categoria no existe");
                categoriaId = temp.get(0).getId();
            } catch (ExceptionService e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ""+e.getMessage(),
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            if(rolesServices.limiteOfertas(CustomerServicesBean.getRol()) > ofertasServices.ofertasporUsuario(solicitanteId).size()){
                ofertasServices.agregarOferta(new Ofertas(nombre.toUpperCase(),descripcion,Estado,categoriaId,solicitanteId));
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se Agrego de forma exitosa la Oferta",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se supera el limite de ofertas",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de agregar una oferta" + e.toString());
        }
    }

    /**
     * Se actualiza el estado de la oferta deseada
     * @throws ExceptionService
     */
    public void actualizarEstadoOferta() throws ExceptionService{
        try {
            
        } catch (Exception e) {
            
        }
    }


    public int getCategoriaId() {
        return categoriaId;
    }
    public String getCategoria() {
        return categoria;
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

    public int getSolicitanteId() {
        return solicitanteId;
    }
    
    public String getEstado(){
        return Estado;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.Estado = estado;
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

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }
    
}
