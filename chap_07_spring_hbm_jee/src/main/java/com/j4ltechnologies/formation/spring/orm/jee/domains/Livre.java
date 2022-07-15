package com.j4ltechnologies.formation.spring.orm.jee.domains;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Classe Livre, créée le 29/04/2021 à 12:16
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "isbn" }, callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Livre extends BaseEntity {

	
	@Column(unique = true)
	@NonNull
	String isbn;

	@NonNull
	String titre;

	@NonNull
	BigDecimal pu;

	@PrePersist
	private void beforePersist() {
		setCreatedAt(LocalDateTime.now());
		isbn = isbn.trim();
	}
}
