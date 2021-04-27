package com.j4ltechnologies.formation.spring.dao.di.setter.test;

import com.j4ltechnologies.formation.spring.dao.di.setter.CompteService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Classe TestXmlConfigDiSetter, créée le 26/04/2021 à 18:35
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public class TestXmlConfigDiSetter {
    public static void main(String[] args) {
        try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("XmlConfigDiSetter.xml")) {
            // Nombre de beans dans le context de Spring
            int nbBeans = context.getBeanDefinitionCount();
            System.out.printf("NB Beans = %d\n", nbBeans);

            //Lister les Beans par leur nom
            var listBeans = context.getBeanDefinitionNames();
            System.out.println(Arrays.toString(listBeans));

            CompteService service = context.getBean(CompteService.class);

            System.out.println("\nAVANT LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s2 = %s\n", service.getCompte(2).getSolde());

            service.transfert(1, 2, 50.);

            System.out.println("\nAPRES LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s2 = %s\n", service.getCompte(2).getSolde());
        }
    }
}
