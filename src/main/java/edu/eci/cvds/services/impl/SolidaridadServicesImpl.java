package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.persistence.CategoriaDAO;
import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.services.SolidaridadServices;

public class SolidaridadServicesImpl implements SolidaridadServices {

    @Inject
    private CategoriaDAO categoriaDAO;

    @Override
    public void registrarCategoria(Categoria categoria){
        categoriaDAO.registrarCategoria(categoria);

    }
}
