package com.j4ltechnologies.formation.spring.orm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j4ltechnologies.formation.spring.orm.AppConfig;
import com.j4ltechnologies.formation.spring.orm.domains.Employe;
import com.j4ltechnologies.formation.spring.orm.services.IEmployeService;
import com.j4ltechnologies.formation.spring.orm.services.impl.EmployeService;

public class TestSpringHbm {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class);){
			Employe joachim = new Employe();
			joachim.setPrenom("Joachim");
			
			Employe ludovic = new Employe();
			ludovic.setPrenom("Ludovic");
			
			IEmployeService service = context.getBean(EmployeService.class);
			
			service.addEmploye(joachim);
			service.addEmploye(ludovic);
			
			System.out.println(joachim);
			System.out.println(ludovic);
		}		
	}
}