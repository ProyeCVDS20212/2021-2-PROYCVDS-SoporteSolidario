package edu.eci.cvds.view;


import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.CategoriaServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;

import org.primefaces.PrimeFaces;

import java.time.LocalTime;
import java.util.Date;

@javax.faces.bean.ManagedBean(name = "categoriaBean")
@SessionScoped
public class CategoriaBean  extends BasePageBean{

    @Inject
    private CategoriaServices CategoriaServices;
    private Categoria categoria;
    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private String oldnombre;


    /**
     * Crea la nueva categoria  se la envia a CategoriaServices para que sea registrada
     * @throws ExceptionService
     */
    public void agregarCategoria() throws ExceptionService {
        try {
            Categoria categorie = new Categoria(nombre.toUpperCase(), descripcion);
            CategoriaServices.registrarCategoria(categorie);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "Categoria creada correctamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            // FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
            cleanData();
        } catch (ExceptionService ex) {
            cleanData();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
            "Ya existe una Categoria con este Nombre");
                        PrimeFaces.current().dialog().showMessageDynamic(message);
        }

        cleanData();
    }


    public void cleanData() {
        descripcion = "";
        nombre = "";
    }

    /**
     * Le envia los paramentros de la categoria a actualizar a CategoriaServices
     * @throws ExceptionService
     */
    public void actualizarCategoria() throws ExceptionService{
        try {
            CategoriaServices.actualizarCategoria(nombre.toUpperCase(), descripcion, estado, oldnombre.toUpperCase());
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar la categoria", e);
        }

    }

    /**
     * Devuelve la categoria
     * @return
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Devuelve el nombre de la categoria
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la fecha de creacion de la categoria
     * @return
     */
    public Date getFechacreacion() {
        return fechacreacion;
    }

    /**
     * Devuelve la fecha de modificacion de la categoria
     * @return
     */
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    /**
     * Devuelve el id de la categoria
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el anterior nombre de la categoria
     * @return
     */
    public String getOldnombre() {
        return oldnombre;
    }

    /**
     * Devuelve la CategoriaServices
     * @return
     */
    public CategoriaServices getCategoriaServices() {
        return CategoriaServices;
    }

    /**
     * Asigna la fecha de creacion de la categoria
     * @param fechacreacion
     */
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /**
     * Asigna la fecha de modificacion de la categoria
     * @param fechamodificacion
     */
    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    /**
     * Asigna el id de la categoria
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Asigna el anterior nombre de la categoria
     * @param oldnombre
     */
    public void setOldnombre(String oldnombre) {
        this.oldnombre = oldnombre;
    }

    /**
     * Asigna la CategoriaServices
     * @param CategoriaServices
     */
    public void setCategoriaServices(CategoriaServices CategoriaServices) {
        this.CategoriaServices = CategoriaServices;
    }

    /**
     * Asigna el nombre de la categoria
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripcion de la categoria
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripcion de la categoria
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el estado de la categoria
     * @return
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Asigna el estado de la categoria
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Asigna la categoria
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
