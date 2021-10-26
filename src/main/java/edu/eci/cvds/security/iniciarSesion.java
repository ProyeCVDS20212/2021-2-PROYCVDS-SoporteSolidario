package edu.eci.cvds.security;

import edu.eci.cvds.services.ExceptionService;

public interface iniciarSesion {
    public void login(String fullName,String password, boolean RememberMe) throws ExceptionService;
    public void logout();
    public boolean isLog();
}