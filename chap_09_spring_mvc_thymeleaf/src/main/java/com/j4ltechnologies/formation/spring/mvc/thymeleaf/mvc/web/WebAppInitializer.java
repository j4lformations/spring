package com.j4ltechnologies.formation.spring.mvc.thymeleaf.mvc.web;

import com.j4ltechnologies.formation.spring.mvc.thymeleaf.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Classe WebAppInitializer, créée le 15/07/2022 à 08:44
 *
 * @author Joachim Zadi
 * @version 1.0 du 15/07/2022
 */
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Chargement de la configuration de l'application Web Spring
        var context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.setServletContext(servletContext);

        // Création et enregistrement de la DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        Dynamic registration = servletContext.addServlet("dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
