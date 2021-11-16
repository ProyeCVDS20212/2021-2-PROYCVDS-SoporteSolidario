package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Necesidad;
import edu.eci.cvds.entities.Ofertas;
import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.ExceptionService;
import edu.eci.cvds.services.NecesidadesServices;
import edu.eci.cvds.services.OfertasServices;
import edu.eci.cvds.services.RespuestaServices;

@ManagedBean(name ="respuestaBean")
@SessionScoped
public class RespuestasBean extends BasePageBean {
    @Inject
    RespuestaServices respuestaServices;
    @Inject
    OfertasServices ofertasServices;
    @Inject
    NecesidadesServices necesidadesServices;
    private int id ;
    private String nombre;
    private String comentario;
    private int ofertaid;
    private int necesidadid;
    private String oferta = "";
    private String necesidad="";

    /**
     * Es usado para controlar la funcionalidad de registrar las respuestas desde la interfaz
     */
    public void registrarRespuesta(){
        try {
            if(necesidad != ""){
                try {
                    List<Necesidad>tempnecesidad =  necesidadesServices.consultarnecesidad(necesidad.toUpperCase());
                    necesidadid =(tempnecesidad.isEmpty())?0:tempnecesidad.get(0).getId();
                    if(!tempnecesidad.get(0).getEstado().equalsIgnoreCase("A")&&!tempnecesidad.get(0).getEstado().equalsIgnoreCase("E")) throw new ExceptionService("Estado no valido");
                } catch (ExceptionService e) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El nombre de la necesidad no es valido o esta esta en un estado no valido",
                    "");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }
            if(oferta != ""){
                try {
                    List<Ofertas>tempofertas =  ofertasServices.verificarOferta(oferta.toUpperCase());
                    ofertaid =(tempofertas.isEmpty())?0:tempofertas.get(0).getId();
                    if(!tempofertas.get(0).getEstado().equalsIgnoreCase("A")&&!tempofertas.get(0).getEstado().equalsIgnoreCase("E")) throw new ExceptionService("Estado no valido");
                } catch (ExceptionService e) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El nombre de la oferta no es valido o esta en un estado no valido",
                    "");
                    FacesContext.getCurrentInstance().addMessage(null, message); 
                }

            }
            if(ofertaid != necesidadid && (ofertaid != 0 || necesidadid != 0)){
                Respuesta temp = new Respuesta(nombre.toUpperCase(), comentario,ofertaid ,necesidadid,CustomerServicesBean.getcustomerId());
                if(ofertaid == 0 ){
                    respuestaServices.registrarRespuestaNecesidad(temp);
                }
                else{
                    respuestaServices.registrarRespuestaOferta(temp);
                }
                
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se agrego de forma exitosa la respuesta",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);

            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo realizar el registro, error en los datos ingresados",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message); 
            }
        } catch (ExceptionService e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo realizar el registro",
            "");
            FacesContext.getCurrentInstance().addMessage(null, message); 
        }
        clean();
    }

    public String getRespue(Respuesta r){
        return r.getNecesidadid()==0?"Oferta "+r.getOfertaid():"Necesidad "+r.getNecesidadid();
    }

    public List<Respuesta> getTabla()throws ExceptionService{
        try{
            return respuestaServices.consultarRespuestas();
        }catch(ExceptionService e){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error Al crear la tabla",
                "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                throw new ExceptionService(e.getMessage());
        }

    }

    public void clean(){
        id =0;
        nombre="";
        comentario="";
        ofertaid=0;
        necesidadid=0;
        oferta = "";
        necesidad="";
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }
    public void setOferta(String oferta) {
        this.oferta = oferta;
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
    public String getNecesidad() {
        return necesidad;
    }
    public String getOferta() {
        return oferta;
    }
    public String getComentario() {
        return comentario;
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
