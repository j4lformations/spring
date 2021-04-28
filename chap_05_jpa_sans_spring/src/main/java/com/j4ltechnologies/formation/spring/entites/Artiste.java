package com.j4ltechnologies.formation.spring.entites;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.j4ltechnologies.formation.spring.utils.JpaUtils;

@Entity
public class Artiste extends AbstractEntity{

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

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Adresse adresse;

	@ManyToMany
	private List<Album> albums;

	// Obligatoire en JPA
	public Artiste() {
	}

	public Artiste(String prenom, String nom, String email, LocalDate ddn) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.ddn = ddn;
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
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@PrePersist
	//@PreUpdate
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
