package edu.eci.cvds.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.mybatis.MyBatisCategoriaDAO;

import java.util.Optional;
import static com.google.inject.Guice.createInjector;

public class SolidaridadServicesFactory {

    private static SolidaridadServicesFactory instance = new SolidaridadServicesFactory();
    private static Optional<Injector> optInjector;

    private SolidaridadServicesFactory() {
        optInjector = Optional.empty();
    }

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(CategoriaDAO.class).to(MyBatisCategoriaDAO.class);
            }
        });
    }
}


