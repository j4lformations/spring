package com.j4ltechnologies.formation.spring.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.j4ltechnologies.formation.spring.utils.JpaUtils;

@Entity
public class Artiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 25)
	private String prenom;
	
	@Column(nullable = false, length = 20)
	private String nom;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(length = 2000)
	private String bio;
	
	private LocalDate ddn;
	
	@Transient
	private int age;
//
//	@ManyToOne
//	private Adresse adresse;

	// Obligatoire en JPA
	public Artiste() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
//	public Adresse getAdresse() {
//		return adresse;
//	}
//
//	public void setAdresse(Adresse adresse) {
//		this.adresse = adresse;
//	}

	@PrePersist
	@PreUpdate
	protected void avantPersistOrMerge() {
		prenom = JpaUtils.capitalize(prenom);
		email = email.trim().toLowerCase();
		nom = nom.trim().toUpperCase();
	}
	
	@PostLoad
	protected void apresChargement() {
		age = JpaUtils.calculeAge(ddn);
	}
}
