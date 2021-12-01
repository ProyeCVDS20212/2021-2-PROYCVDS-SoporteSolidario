package edu.eci.cvds.view;

import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import  javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

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
    private String estado;
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
                if(rolesServices.limiteOfertas(CustomerServicesBean.getRol()) > ofertasServices.ofertasporUsuario(solicitanteId).size()){
                    ofertasServices.agregarOferta(new Ofertas(nombre.toUpperCase(),descripcion,estado,categoriaId,solicitanteId));
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se Agrego de forma exitosa la Oferta",
                            "");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                else{
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se supera el limite de ofertas",
                            "");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } catch (ExceptionService e) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, ""+e.getMessage(),
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        } catch (Exception e) {
            clear();
            throw new ExceptionService("Se produjo un error a la hora de agregar una oferta" + e.toString());
        }
        clear();
    }

    /**
     * Se actualiza el estado de la oferta deseada
     * @throws ExceptionService
     */
    public void actualizarEstadoOferta() throws ExceptionService{
            try {
                solicitanteId = CustomerServicesBean.getcustomerId();
                if(ofertasServices.verificarOferta(nombre.toUpperCase()).get(0).getSolicitanteId() == solicitanteId || rolesServices.getRol(CustomerServicesBean.getRol()).equals("Administrador")){
                    ofertasServices.actualizarEstadoOferta(solicitanteId,nombre.toUpperCase(), estado);
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Oferta Fue actualizada de forma exitosa", "");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    clear();
                }else
                {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No tienes permisos para modificar esta Oferta",
                    "");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    clear();
                }
            } catch (Exception e) {
                throw new ExceptionService("Se produjo un error a la hora de actualizar una oferta " + e.getMessage());
            }
    }

    public List<Ofertas> getTabla(){
        try{
            return ofertasServices.consultarOfertas();
        }catch(ExceptionService e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error Al crear la tabla",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                clear();
        }
        return null;
    }

    private BarChartModel initBar(){
        BarChartModel  model = new BarChartModel ();
        ChartSeries  chartSeries = new ChartSeries();
        chartSeries.setLabel("Ofertas");
        model.setSeriesColors("823acf,32e33b,ffffff,e352c6");
        int[] values = new int[4];
        for(Ofertas a : getTabla()){
            if(a.getEstado().equalsIgnoreCase( "A")){
                values[0] +=1;
            }else if(a.getEstado().equalsIgnoreCase( "C")){
                values[1] +=1;
            }
            else if(a.getEstado().equalsIgnoreCase( "E")){
                values[2] +=1;
            }else if(a.getEstado().equalsIgnoreCase( "R")){
                values[3] +=1;
            }
        }
        chartSeries.set("Activo", values[0]);
        chartSeries.set("Cerrada", values[1]);
        chartSeries.set("En Proceso", values[2]);
        chartSeries.set("Resuelta", values[3]);
        model.addSeries(chartSeries);
        return model;
    }
    
        public BarChartModel getGrafico() throws ExceptionService{
            BarChartModel model = initBar();
            model.setTitle("Ofertas agrupadas por estado");
            model.setLegendPosition("ne");
            Axis xAxis = model.getAxis(AxisType.X);
            xAxis.setLabel("Estados");
            Axis yAxis = model.getAxis(AxisType.Y);
            yAxis.setMin(0);
    
            return model;
        }

    public String intoEstado(String a){
        String res = "";
        switch(a){
            case "A":
                res = "Activo";
                break;
            case "C":
                res = "Cerrado";
                break;
            case "E":
                res = "En Proceso";
                break;
            case "R":
                res = "Resuelta";
                break;
        }
        return res;
    }
    private void clear(){
        id = 0;
        nombre="";
        descripcion="";
        estado="A";
        categoriaId=0;
        solicitanteId=0;
        categoria="";
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
        return estado;
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

    public void setSolicitanteId(int solicitanteId) {
        this.solicitanteId = solicitanteId;
    }
    
}
