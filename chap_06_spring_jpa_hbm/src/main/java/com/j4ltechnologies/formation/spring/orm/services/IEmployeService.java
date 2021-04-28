package com.j4ltechnologies.formation.spring.orm.services;

import java.util.List;

import com.j4ltechnologies.formation.spring.orm.domains.Employe;

public interface IEmployeService {

	List<Employe> allEmployes();

	Employe addEmploye(Employe employe);
}
