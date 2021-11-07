package edu.eci.cvds.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.services.RolesServices;

@ManagedBean(name = "rolBean")
@SessionScoped
public class RolesBean extends BasePageBean {
    @Inject
    RolesServices rolesServices;

    String rol;
    int limiteO;
    int limiteN;


    public void acualizarlimites(){
        try {
            rolesServices.actualizarLimites(rol, limiteO, limiteN);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se realizo la modificacion",
            "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            clean();
        } catch (PersistenceException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo realizar la modificacion",
            "");
            FacesContext.getCurrentInstance().addMessage(null, message); 
        }
    }


    private void clean(){
        rol = "";
        limiteO=0;
        limiteN=0;
    }
    public String visible(){
        String res="";
        try{
            res = (rolesServices.getRol(CustomerServicesBean.getRol()).equals("Administrador"))?"True":"None";
        } catch(PersistenceException e) {
            res="None";
        }

        return res;
    }

public int limiteOfertas(){
    try {
        return rolesServices.limiteOfertas(rol);
    } catch (Exception e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo realizar la modificacion",
        "");
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    return 0;
}
public int limiteNecesidades(){
    try {
        return rolesServices.limiteNecesidades(rol);
    } catch (Exception e) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo realizar la modificacion",
        "");
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
    return 0;
}
public int getLimiteO() {
    return limiteO;
}
public int getLimiteN() {
    return limiteN;
}
public void setLimiteO(int limiteO) {
    
    this.limiteO = limiteO;
}
public void setLimiteN(int limiteN) {
    this.limiteN = limiteN;
}
 
public String getRol() {
     return rol;
}

    public void setRol(String rol) {
        this.rol = rol;
        PrimeFaces.current().ajax().update("form");
    }
    
}
