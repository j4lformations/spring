package com.j4ltechnologies.formation.spring.dao;

import com.j4ltechnologies.formation.spring.domains.Compte;

/**
 * Classe ICompteService, créée le 26/04/2021 à 18:13
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public interface ICompteService {
    void transfert(Integer numSource, Integer numDestination, Double montant);

    void crediter(Integer numero, Double montant);

    Compte getCompte(Integer numero);
}
