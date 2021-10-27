package edu.eci.cvds.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.dao.*;
import edu.eci.cvds.dao.mybatis.*;
import edu.eci.cvds.services.impl.*;

import java.util.Optional;
import static com.google.inject.Guice.createInjector;

public class CategoriaServicesFactory {

    private static CategoriaServicesFactory instance = new CategoriaServicesFactory();
    private static Optional<Injector> optInjector;

    private CategoriaServicesFactory() {
        optInjector = Optional.empty();
    }

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(CategoriaDAO.class).to(MyBatisCategoriaDAO.class);
                bind(CustomerDAO.class).to(MyBatisCustomerDAO.class);
                bind(CustomerServices.class).to(CustomerServicesImpl.class);
                bind(CategoriaServices.class).to(CategoriaServicesImpl.class);
            }
        });
    }

    public CustomerServices getServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(CustomerServices.class);
    }

    public static CategoriaServicesFactory getInstance(){
        return instance;
    }
}


