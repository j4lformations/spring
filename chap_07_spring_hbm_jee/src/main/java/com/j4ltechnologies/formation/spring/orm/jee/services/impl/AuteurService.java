package com.j4ltechnologies.formation.spring.orm.jee.services.impl;

import com.j4ltechnologies.formation.spring.orm.jee.domains.Auteur;
import com.j4ltechnologies.formation.spring.orm.jee.domains.Livre;
import com.j4ltechnologies.formation.spring.orm.jee.repositories.AuteurRepository;
import com.j4ltechnologies.formation.spring.orm.jee.repositories.LivreRepository;
import com.j4ltechnologies.formation.spring.orm.jee.services.IAuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Classe AuteurService, créée le 29/04/2021 à 13:49
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */
@Service
public class AuteurService implements IAuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Auteur> allAuteurs() {
        return auteurRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Livre> allLivres() {
        return livreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Auteur findAuteur(Integer id) {
        return auteurRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Auteur findAuteur(String prenom, String nom) {
        return auteurRepository.findByPrenomAndNom(prenom, nom);
    }

    @Override
    @Transactional
    public void saveOrMajAuteur(Auteur auteur, Livre livre) {
        if (!allAuteurs().contains(auteur)) {
            Livre livreBdd = livreRepository.findByIsbn(livre.getIsbn());
            if (livreBdd != null) {
                auteur.addLivre(livreBdd);
            } else {
                livre = livreRepository.save(livre);
                auteur.addLivre(livre);
            }
            auteurRepository.save(auteur);
        } else {
            auteur = auteurRepository.findByEmail(auteur.getEmail());
            if (!auteur.getLivres().contains(livre)) {
                livre = livreRepository.save(livre);
                auteur.addLivre(livre);
                auteurRepository.save(auteur);
            }
        }
    }

    @Override
    public void deleteAuteur(Integer integer) {

    }
}
