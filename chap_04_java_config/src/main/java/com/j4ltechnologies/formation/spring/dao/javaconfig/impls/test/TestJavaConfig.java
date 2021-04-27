package com.j4ltechnologies.formation.spring.dao.javaconfig.impls.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.j4ltechnologies.formation.spring.dao.javaconfig.AppConfig;
import com.j4ltechnologies.formation.spring.dao.javaconfig.impls.CompteService;
import com.j4ltechnologies.formation.spring.domains.Compte;

public class TestJavaConfig {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			CompteService service = context.getBean(CompteService.class);

            System.out.println("\nAVANT LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s3 = %s\n", service.getCompte(3).getSolde());

            service.transfert(3, 1, 50.);

            System.out.println("\nAPRES LE TRANSFERT\n");
            System.out.printf("s1 = %s\n", service.getCompte(1).getSolde());
            System.out.printf("s3 = %s\n", service.getCompte(3).getSolde());
            
            System.out.println("\nRECHERCHE DU BEAN\n");
            Compte compte = context.getBean(Compte.class);
            
            System.out.println(compte);
		}
	}
}
