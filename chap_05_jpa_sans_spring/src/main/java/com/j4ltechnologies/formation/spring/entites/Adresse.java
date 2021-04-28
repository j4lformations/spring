package com.j4ltechnologies.formation.spring.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;

	@OneToMany
	@JoinColumn(name = "adresseId")
	private Set<Artiste> artistes;

	public Adresse() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}