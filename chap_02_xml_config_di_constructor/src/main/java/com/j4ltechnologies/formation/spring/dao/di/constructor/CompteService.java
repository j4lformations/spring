package com.j4ltechnologies.formation.spring.dao.di.constructor;

import com.j4ltechnologies.formation.spring.dao.ICompteService;
import com.j4ltechnologies.formation.spring.domains.Compte;

/**
 * Classe CompteService, créée le 26/04/2021 à 18:52
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public class CompteService implements ICompteService {

    private CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public void transfert(Integer numSource, Integer numDestination, Double montant) {
        Compte source = compteRepository.find(numSource);
        Compte destination = compteRepository.find(numDestination);
        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);
        compteRepository.update(source);
        compteRepository.update(destination);
    }

    @Override
    public void crediter(Integer numero, Double montant) {
        Compte compte = compteRepository.find(numero);
        compte.setSolde(compte.getSolde() + montant);
        compteRepository.update(compte);
    }

    @Override
    public Compte getCompte(Integer numero) {
        return compteRepository.find(numero);
    }
}
