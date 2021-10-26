package edu.eci.cvds.view;

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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.util.List;

public class CustomerBean  extends PageBean{
    private String correo;
    private String password;
    public static int customerID;
    private String fullname;
    private String username;
    private static int rol;
    private Subject subject;
    private boolean isActive = false;
    private CustomerServices customerServices;
    private final String redirectUrl = "/app/login.xhtml";

    public static int getId() {
        return customerID;
    }

    public void setId(int id) {
        this.customerID = id;
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
        return isActive;
    }

    public void setIsactive(boolean isactive) {
        this.isActive = isactive;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * Permite iniciar sesion desde la interfaz
     * @throws Exception Excepciones no atrapadas como casos bases
     */
    public void IngresarSesion() throws Exception {
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject = SecurityUtils.getSubject();
        Logger log = LoggerFactory.getLogger(CustomerBean.class);
        try {
            //Verificar actividad del cliente
            Customer datos = customerServices.IngresarSesion(username).get(0);
            if (null!=datos)isActive= datos.getIsActive();
            if (isActive){
                    customerID = datos.getCustomerID();
                    fullname = datos.getName();
                    rol = datos.getRol();
                    correo = datos.getEmail();
                    subject.login(token);//crear token activo
                    FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");       
                }
            else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario esta inactivo"));
                    new ExceptionService("Usuario inactivo");
            }
        }catch (UnknownAccountException ex) {
                error("Cuenta Inexistente!");
                log.error(ex.getMessage(), ex);
        }catch (IncorrectCredentialsException ex) {
                error("Contraseña incorrecta");
                log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
                error("Cuenta Bloqueada");
                log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
                error("Error no manejado" + ex.getMessage());
                log.error(ex.getMessage(), ex);
        }finally {
                token.clear();
        }

    }
    /**
     * Agrega el mensaje de error que sucedio en el momemento de hacer el inicio de sesion
     * @param e mensaje con motivo de error
     */
    private void error(String e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e));
    }
}
