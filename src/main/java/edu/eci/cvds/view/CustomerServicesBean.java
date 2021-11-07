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
    public void ingresarSesion() throws Exception {
        Logger log = LoggerFactory.getLogger(CustomerServices.class);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject = SecurityUtils.getSubject();
        try {
            //comprobar si está activo
            List<Customer> datos = userServices.ingresarSesion(username);
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

    public String nombre(int numero){
        try {
            return userServices.nombreUsuario(numero);
        } catch (ExceptionService e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en consulta nombre", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "";
    }

    /**
     * Cierra la sesion 
     */
    public void cerrarSesion() {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CustomerServicesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lanza el mensaje de error
     * @param message
     */
    private void messageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
    }

    /**
     * Devuelve el customerId
     * @return
     */
    public static int getcustomerId() {
        return customerId;
    }

    /**
     * Asigna el customerId
     * @param id
     */
    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Devuelve el name
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Asigna el name
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Devuelve el username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /***
     * Asigna el username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devuelve el rol
     * @return
     */
    public static int getRol() {
        return rol;
    }

    /**
     * Asigna el rol
     * @param rol
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * Devuelve si esta activo
     * @return
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * Asigna si esta activo
     * @param isactive
     */
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    /***
     * Devuelve el userServices
     * @return
     */
    public CustomerServices getUserServices() {
        return this.userServices;
    }

    /**
     * Asigna el userServices
     * @param userServices
     */
    public void setUserServices(CustomerServices userServices) {
        this.userServices = userServices;
    }

    /**
     * Devuelve el email
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Asigna el email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la contraseña
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Asigna la contraseña
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
