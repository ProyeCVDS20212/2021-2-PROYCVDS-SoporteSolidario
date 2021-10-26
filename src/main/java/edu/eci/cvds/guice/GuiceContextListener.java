package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.dao.CategoriaDAO;
import edu.eci.cvds.dao.mybatis.MyBatisCategoriaDAO;
import edu.eci.cvds.services.SolidaridadServices;
import edu.eci.cvds.services.impl.SolidaridadServicesImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;


public class GuiceContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent){
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent){
        Injector injector = Guice.createInjector(new XMLMyBatisModule(){
            @Override
            protected void initialize(){

                install(JdbcHelper.PostgreSQL);

                setEnvironmentId("development");

                setClassPathResource("mybatis-config.xml");

                //Servicios
                bind(SolidaridadServices.class).to(SolidaridadServicesImpl.class);
                //Categoria
                bind(CategoriaDAO.class).to(MyBatisCategoriaDAO.class);


            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}
