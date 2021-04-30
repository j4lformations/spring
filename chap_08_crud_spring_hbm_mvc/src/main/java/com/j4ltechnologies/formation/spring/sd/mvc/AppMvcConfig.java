package com.j4ltechnologies.formation.spring.sd.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Classe AppMvcConfig, créée le 30/04/2021 à 16:42
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.j4ltechnologies.formation.spring.sd")
public class AppMvcConfig {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
