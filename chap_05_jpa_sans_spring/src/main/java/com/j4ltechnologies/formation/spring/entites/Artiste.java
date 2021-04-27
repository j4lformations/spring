package com.j4ltechnologies.formation.spring.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artiste {

	@Id
	private Integer id;

	@Column(nullable = false)
	private String prenom;
	private String nom;

	@Column(unique = true)
	private String email;

	@Column(length = 2000)
	private String bio;
	private LocalDate ddn;
	private int age;

	public Artiste(Integer id, String prenom, String nom, String email, String bio, LocalDate ddn) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.bio = bio;
		this.ddn = ddn;
	}

	public Artiste(Integer id, String prenom, String nom, String email, LocalDate ddn) {
		this(id, prenom, nom, email, "", ddn);
	}
	
	public Artiste(String prenom, String nom, String email, LocalDate ddn) {
		this(null, prenom, nom, email, "", ddn);
	}

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

}
