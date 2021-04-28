package com.j4ltechnologies.formation.spring.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Adresse extends AbstractEntity{

	private String libelle;

//	@OneToMany
//	@JoinColumn(name = "adresseId")
//	private Set<Artiste> artistes;

	public Adresse() {

	}

	public Adresse(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}