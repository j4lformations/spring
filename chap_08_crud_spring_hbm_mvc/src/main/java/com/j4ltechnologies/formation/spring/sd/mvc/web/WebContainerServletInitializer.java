package com.j4ltechnologies.formation.spring.sd.mvc.web;

import com.j4ltechnologies.formation.spring.sd.mvc.AppMvcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Classe WebContainerServletInitializer, créée le 30/04/2021 à 16:51
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
public class WebContainerServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        var context = new AnnotationConfigWebApplicationContext();
        context.register(AppMvcConfig.class);
        context.setServletContext(servletContext);

        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
