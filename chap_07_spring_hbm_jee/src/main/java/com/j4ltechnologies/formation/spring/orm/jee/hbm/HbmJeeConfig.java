package com.j4ltechnologies.formation.spring.orm.jee.hbm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;

/**
 * Classe HbmJeeConfig, créée le 29/04/2021 à 11:54
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

@Configuration
@EnableJpaRepositories(basePackages = {"com.j4ltechnologies.formation.spring.orm.jee"})
public class HbmJeeConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("SPRING_HMB_PU");
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}