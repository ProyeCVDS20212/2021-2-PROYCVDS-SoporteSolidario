package edu.eci.cvds.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.CategoriaServices;
import edu.eci.cvds.services.ExceptionService;

public class CategoriaServicesImpl implements CategoriaServices {

    @Inject
    CategoriaDAO categoriaDAO;

    
    @Override
    public void registrarCategoria(Categoria categoria) throws ExceptionService{
        try {
            categoriaDAO.registrarCategoria(categoria);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de registrar una categoria", e);
        }

    }

    @Override
    public void actualizarCategoria(String nombre, String descripcion, boolean estado, String oldnombre) throws ExceptionService {
        try {
            List<Categoria> existeNuevaCategoria = verificarCategoria(nombre);
            List<Categoria> existeCategoria = verificarCategoria(oldnombre);
            if(!existeCategoria.isEmpty()){
                if(existeNuevaCategoria.isEmpty()){
                    categoriaDAO.actualizarCategoria(nombre, descripcion, estado, oldnombre);
                    FacesMessage messageCorrect = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                            "Categoria actualizada correctamente");
                    PrimeFaces.current().dialog().showMessageDynamic(messageCorrect);
                }
                else{
                    FacesMessage messageExiste =new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La categoria con ese nombre ya existe");
                    PrimeFaces.current().dialog().showMessageDynamic(messageExiste);
                }
            }
            else{
                FacesMessage messageExiste =new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La categoria que desea actualizar no existe");
                    PrimeFaces.current().dialog().showMessageDynamic(messageExiste);
            }
            
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de actualizar una categoria", e);
        }
        
    }

    @Override
    public List<Categoria> verificarCategoria(String oldnombre) throws ExceptionService {
        try {
            return categoriaDAO.verificarCategoria(oldnombre);
        } catch (Exception e) {
            throw new ExceptionService("Se produjo un error a la hora de verificar si existe la categoria", e);
        }
        
    }
}
