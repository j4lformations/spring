package com.j4ltechnologies.formation.spring.dao.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.j4ltechnologies.formation.spring.domains.Compte;

@Configuration
@ComponentScan("com.j4ltechnologies.formation.spring")
public class AppConfig {

	@Bean
	public Compte getCompte() {
		Compte compte = new Compte(12, "Loudjair", 4500.);
		return compte;
	}
}
