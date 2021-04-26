package com.j4ltechnologies.formation.spring.dao.di.constructor.test;

import com.j4ltechnologies.formation.spring.dao.di.constructor.CompteService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Classe TestXmlConfigDiConstructor, créée le 26/04/2021 à 19:05
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public class TestXmlConfigDiConstructor {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("XmlConfigDiConstructor.xml")) {

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
