package com.j4ltechnologies.formation.spring.orm.repositories;

import java.util.List;

import com.j4ltechnologies.formation.spring.orm.domains.Employe;

public interface IEmployeRepository {
	List<Employe> allEmployes();

	Employe addEmploye(Employe employe);
}