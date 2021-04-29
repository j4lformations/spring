package com.j4ltechnologies.formation.spring.orm.jee.repositories;

import com.j4ltechnologies.formation.spring.orm.jee.domains.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe AuteurRepository, créée le 29/04/2021 à 12:47
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
    Auteur findByEmail(String email);
    Auteur findByPrenomAndNom(String prenom, String nom);
}
