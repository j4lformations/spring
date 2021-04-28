package com.j4ltechnologies.formation.spring.orm.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.j4ltechnologies.formation.spring.orm.domains.Employe;
import com.j4ltechnologies.formation.spring.orm.repositories.IEmployeRepository;

@Repository
@Transactional
public class EmployeRepository implements IEmployeRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employe> allEmployes() {
		TypedQuery<Employe> requete = em.createQuery("select e from Employe e", Employe.class);
		return requete.getResultList();
	}

	@Override
	public Employe addEmploye(Employe employe) {
		if(!allEmployes().contains(employe)) {
			em.persist(employe);
		}
		return employe;
	}
}
