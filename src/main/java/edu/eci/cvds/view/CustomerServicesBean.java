package edu.eci.cvds.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import org.slf4j.LoggerFactory;


import edu.eci.cvds.entities.Customer;
import edu.eci.cvds.services.CustomerServices;
import edu.eci.cvds.services.ExceptionService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import java.util.logging.Level;

import java.io.IOException;
import java.util.List;


@ManagedBean(name = "customerBean")
@SessionScoped
public class CustomerServicesBean extends BasePageBean {

    @Inject
    private CustomerServices userServices;
    private String email;
    private String password;
    public static int customerId;
    private String fullname;
    private String username;
    private static int rol;
    private boolean isactive = false;
    Subject subject;
    private String redirectUrl = "/app/login.xhtml";
    /**
     * Es usado para controlar la funcionalidad de iniciar sesion desde la interfaz
     * 
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    public void IngresarSesion() throws Exception {
        Logger log = LoggerFactory.getLogger(CustomerServices.class);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject = SecurityUtils.getSubject();
        try {
            //comprobar si está activo
            List<Customer> datos = userServices.IngresarSesion(username);
            if (!datos.isEmpty())isactive= datos.get(0).getIsActive();
            if (isactive){
                    customerId = datos.get(0).getCustomerID();
                    fullname = datos.get(0).getName();
                    rol = datos.get(0).getRol();
                    email = datos.get(0).getEmail();
                    subject.login(token);//crear token activo
                    FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");       
                }
            else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario esta inactivo"));
                    new ExceptionService("Usuario inactivo");
            }
        }catch (UnknownAccountException ex) {
                messageError("Esta cuenta no existe");
                log.error(ex.getMessage(), ex);
        }catch (IncorrectCredentialsException ex) {
                messageError("Contraseña incorrecta");
                log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
                messageError("La Cuenta esta Bloqueada");
                log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
                messageError("Error desconocido: " + ex.getMessage());
                log.error(ex.getMessage(), ex);
        } finally {
                token.clear();
        }

    }

    public void cerrarSesion() {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CustomerServicesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void messageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
    }
    public static int getId() {
        return customerId;
    }

    public void getcustomerId(int id) {
        this.customerId = customerId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public CustomerServices getUserServices() {
        return this.userServices;
    }

    public void setUserServices(CustomerServices userServices) {
        this.userServices = userServices;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
