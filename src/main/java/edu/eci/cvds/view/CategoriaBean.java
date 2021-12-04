package edu.eci.cvds.view;


import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;
import edu.eci.cvds.services.OfertasServices;
import edu.eci.cvds.services.CategoriaServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@javax.faces.bean.ManagedBean(name = "categoriaBean")
@SessionScoped
public class CategoriaBean  extends BasePageBean{

    @Inject
    private CategoriaServices categoriaServices;
    @Inject
    private NecesidadesServices necesidadesServices;
    @Inject
    private OfertasServices ofertasServices;
    private Categoria categoria = new Categoria(true,true);
    private int id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private String oldnombre;
    private boolean esValido;
    private String descripcionInvalida;


    /**
     * Crea la nueva categoria  se la envia a CategoriaServices para que sea registrada
     * @throws ExceptionService
     */
    public void agregarCategoria() throws ExceptionService {
        try {
            categoriaServices.registrarCategoria(categoria);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria creada correctamente", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            //PrimeFaces.current().dialog().showMessageDynamic(message);
            cleanData();
        } catch (ExceptionService ex) {
            ex.printStackTrace();
            cleanData();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ya existe una Categoria con este Nombre",
            "");
            FacesContext.getCurrentInstance().addMessage(null, message);
                        //PrimeFaces.current().dialog().showMessageDynamic(message);
        }
        cleanData();
    }

    public void nuevaC() {
        this.categoria = new Categoria();
        categoria.setEstado(true);
        categoria.setEsValido(true);
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
            categoriaServices.actualizarCategoria(nombre, descripcion, estado, oldnombre);
        } catch (ExceptionService e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar la categoria", e);
        }

    }
    /**
     * Envia el parametro del nombre de la categoria que se desea eliminar a CategoriaServices
     * @throws ExceptionService
     */
    public void eliminarCategoria() throws ExceptionService{
        try {
            categoriaServices.eliminarCategoria(nombre);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria eliminada correctamente",
                    "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se produjo un error a la hora de eliminar la categoria",
                    "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<List<String>> getTabla(){
        List<List<String>> ans = new ArrayList<>();
        try {
            for(Categoria c :categoriaServices.consultarCategoriasV()){
                List<String> temp = new ArrayList<>();
                temp.add(""+c.getId());
                temp.add(c.getNombre());
                temp.add(""+ofertasServices.consultarOfertasCategorias(c.getId()));
                temp.add(""+necesidadesServices.consultarNecesidadCategorias(c.getId()));
                temp.add(""+(ofertasServices.consultarOfertasCategorias(c.getId())+necesidadesServices.consultarNecesidadCategorias(c.getId())));
                ans.add(temp);
            }
            return ans;
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se produjo un error a la crear la tabla",
                    "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return ans;
    }

    private BarChartModel initBarO(){
        BarChartModel  model = new BarChartModel ();
        ChartSeries  chartSeries = new ChartSeries();
        chartSeries.setLabel("Categorias");
        model.setSeriesColors("823acf,32e33b,ffffff,e352c6");
        for(List<String> a : getTabla()){
            chartSeries.set(a.get(1), Integer.valueOf(a.get(2)));
        }
        model.addSeries(chartSeries);
        return model;
    }
    
        public BarChartModel getGraficoO()  {
            BarChartModel model = initBarO();
            model.setTitle("Categorias mas ofrecidas");
            model.setLegendPosition("ne");
            Axis xAxis = model.getAxis(AxisType.X);
            xAxis.setLabel("Categorias");
            Axis yAxis = model.getAxis(AxisType.Y);
            yAxis.setMin(0);
    
            return model;
        }


        private BarChartModel initBarN(){
            BarChartModel  model = new BarChartModel ();
            ChartSeries  chartSeries = new ChartSeries();
            chartSeries.setLabel("Categorias");
            model.setSeriesColors("823acf,32e33b,ffffff,e352c6");
            for(List<String> a : getTabla()){
                chartSeries.set(a.get(1), Integer.valueOf(a.get(3)));
            }
            model.addSeries(chartSeries);
            return model;
        }
        
            public BarChartModel getGraficoN()  {
                BarChartModel model = initBarN();
                model.setTitle("Categorias mas Necesitadas");
                model.setLegendPosition("ne");
                Axis xAxis = model.getAxis(AxisType.X);
                xAxis.setLabel("Categorias");
                Axis yAxis = model.getAxis(AxisType.Y);
                yAxis.setMin(0);
        
                return model;
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
        return categoriaServices;
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
    public void setCategoriaServices(CategoriaServices categoriaServices) {
        this.categoriaServices = categoriaServices;
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

    public boolean getEsValido() {
        return esValido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    public String getDescripcionInvalida() {
        return descripcionInvalida;
    }

    public void setDescripcionInvalida(String descripcionInvalida) {
        this.descripcionInvalida = descripcionInvalida;
    }
}
