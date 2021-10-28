package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.dao.*;
import edu.eci.cvds.dao.mybatis.*;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.impl.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");              
                bind(CategoriaDAO.class).to(MyBatisCategoriaDAO.class);
                bind(CustomerDAO.class).to(MyBatisCustomerDAO.class);
                bind(CustomerServices.class).to(CustomerServicesImpl.class);
                bind(CategoriaServices.class).to(CategoriaServicesImpl.class);
                bind(NecesidadesDAO.class).to(MyBatisNecesidadesDAO.class);
                bind(NecesidadesServices.class).to(NecesidadesServicesImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
