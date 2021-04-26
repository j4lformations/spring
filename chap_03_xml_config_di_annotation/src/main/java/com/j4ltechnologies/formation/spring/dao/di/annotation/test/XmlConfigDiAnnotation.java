package com.j4ltechnologies.formation.spring.dao.di.annotation.test;

import com.j4ltechnologies.formation.spring.dao.di.annotation.CompteService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Classe XmlConfigDiAnnotation, créée le 26/04/2021 à 19:23
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public class XmlConfigDiAnnotation {
    public static void main(String[] args) {
        try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("XmlConfigDiAnnotation.xml")) {
            // Nombre de beans dans le context de Spring
            int nbBeans = context.getBeanDefinitionCount();
            System.out.printf("NB Beans = %d\n", nbBeans);

            //Lister les Beans par leur nom
            var listBeans = context.getBeanDefinitionNames();
            System.out.println(Arrays.toString(listBeans));

            CompteService service = (CompteService) context.getBean("compteService");

            System.out.println("\nAVANT LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s3 = %s\n", service.getCompte(3).getSolde());

            service.transfert(3, 1, 50.);

            System.out.println("\nAPRES LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s3 = %s\n", service.getCompte(3).getSolde());
        }
    }
}
