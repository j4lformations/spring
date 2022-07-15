package com.j4ltechnologies.formation.spring.orm.jee.domains;

import com.j4ltechnologies.formation.spring.orm.jee.utils.AppUtils;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Auteur, créée le 29/04/2021 à 11:56
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "email" }, callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Auteur extends BaseEntity {

	@Column(unique = true)
	@NonNull
	String email;

	@Column(nullable = false)
	@NonNull
	String prenom;

	@Column(nullable = false)
	@NonNull
	String nom;

	@NonNull
	LocalDate ddn;

	@Transient
	int age;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Livre> livres;

	public void addLivre(Livre livre) {
		if (livres == null) {
			livres = new ArrayList<>();
		}
		if (!livres.contains(livre)) {
			livres.add(livre);
		}
	}

	@PrePersist
	private void beforePersist() {
		setCreatedAt(LocalDateTime.now());
		email = email.trim().toLowerCase();
		prenom = AppUtils.capitalize(prenom);
		nom = nom.trim().toUpperCase();
	}

	@PostLoad
	private void postLoad() {
		age = AppUtils.calculeAge(ddn);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}
}
