package com.j4ltechnologies.formation.spring.orm.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Classe Employe, créée le 28/04/2021 à 15:48
 *
 * @author Joachim Zadi
 * @version 1.0 du 28/04/2021
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"prenom"})
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String prenom;

    public Employe() {
    }
}
