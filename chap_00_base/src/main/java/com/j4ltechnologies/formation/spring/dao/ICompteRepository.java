package com.j4ltechnologies.formation.spring.dao;

import com.j4ltechnologies.formation.spring.domains.Compte;

import java.util.List;

/**
 * Classe ICompteRepository, créée le 26/04/2021 à 18:11
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public interface ICompteRepository {

    void insert(Compte compte);

    void update(Compte compte);

    void update(List<Compte> comptes);

    void delete(Integer numero);

    Compte find(Integer numero);

    List<Compte> find(List<Integer> numeros);

    List<Compte> find(String titulaire);

    List<Compte> find(Boolean fermer);
}
