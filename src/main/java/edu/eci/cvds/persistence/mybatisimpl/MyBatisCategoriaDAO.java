package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Categoria;
import edu.eci.cvds.persistence.CategoriaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.CategoriaMapper;


import javax.inject.Inject;

public class MyBatisCategoriaDAO implements CategoriaDAO {

    @Inject
    private CategoriaMapper categoriaMapper;

    @Override
    public void registrarCategoria(Categoria categoria) {
        categoriaMapper.añadirCategoria(categoria);
    }
}
