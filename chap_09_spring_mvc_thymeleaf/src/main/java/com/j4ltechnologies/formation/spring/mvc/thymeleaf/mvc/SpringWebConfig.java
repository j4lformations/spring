package com.j4ltechnologies.formation.spring.mvc.thymeleaf.mvc;

import com.j4ltechnologies.formation.spring.mvc.thymeleaf.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Classe SpringWebConfig, créée le 15/07/2022 à 08:50
 *
 * @author Joachim Zadi
 * @version 1.0 du 15/07/2022
 */
@Configuration
@EnableWebMvc
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        /*
         * SpringResourceTemplateResolver s'intègre automatiquement avec Spring
         * pour la résolution des ressources, ce qui est fortement recommandé.
         */
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/pages/");
        templateResolver.setSuffix(".html");

        // HTML est la valeur par défaut, ajoutée ici par souci de clarté.
        templateResolver.setTemplateMode(TemplateMode.HTML);

        /*
         * Le cache du modèle est vrai par défaut.
         * Définissez sur false si vous le souhaitez
         * Les modèles sont mis à jour automatiquement lorsqu'ils sont modifiés.
         */
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        /*
         * SpringTemplateEngine applique automatiquement SpringStandardDialect et
         * active les propres mécanismes de résolution de messages MessageSource de Spring.
         */
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());

        /*
         * L'activation du compilateur SpringEL avec Spring 4.2.4 ou une version plus récente peut
         * accélérer l'exécution dans la plupart des scénarios, mais peut être incompatible
         * avec des cas spécifiques lorsque les expressions d'un modèle sont réutilisées
         * sur différents types de données, cet indicateur est donc "faux" par défaut
         * pour une rétrocompatibilité plus sûre.
         */
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }
}
