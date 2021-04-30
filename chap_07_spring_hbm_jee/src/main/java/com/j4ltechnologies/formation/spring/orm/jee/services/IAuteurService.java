package com.j4ltechnologies.formation.spring.orm.jee.services;

import com.j4ltechnologies.formation.spring.orm.jee.domains.Auteur;
import com.j4ltechnologies.formation.spring.orm.jee.domains.Livre;

import java.util.List;

/**
 * Classe IAuteurService, créée le 29/04/2021 à 13:44
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */
public interface IAuteurService {

    List<Auteur> allAuteurs();

    List<Livre> allLivres();

    Auteur findAuteur(Integer id);

    Auteur findAuteur(String prenom, String nom);

    void saveOrMajAuteur(Auteur auteur, Livre livre);

    void deleteAuteur(Integer integer);
}