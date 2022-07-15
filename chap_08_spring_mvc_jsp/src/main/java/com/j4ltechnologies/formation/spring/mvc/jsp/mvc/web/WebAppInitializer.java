package com.j4ltechnologies.formation.spring.mvc.jsp.mvc.web;

import com.j4ltechnologies.formation.spring.mvc.jsp.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Classe WebAppInitializer, créée le 15/07/2022 à 08:44
 *
 * Cette configuration est recommandé pour les applications qui utilisent une configuration Spring
 * basée sur Java
 *
 * @author Joachim Zadi
 * @version 1.0 du 15/07/2022
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
