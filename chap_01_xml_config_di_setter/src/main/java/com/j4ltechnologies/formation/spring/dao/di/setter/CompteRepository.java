package com.j4ltechnologies.formation.spring.dao.di.setter;

import com.j4ltechnologies.formation.spring.dao.ICompteRepository;
import com.j4ltechnologies.formation.spring.domains.Compte;

import java.util.*;

/**
 * Classe CompteRepository, créée le 26/04/2021 à 18:18
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
public class CompteRepository implements ICompteRepository {
    private Map<Integer, Compte> comptes = new HashMap<>();

    // Injection de dependance par setter
    public void setComptes(Map<Integer, Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public void insert(Compte compte) {
        if (!comptes.containsKey(compte.getNumero())) {
            comptes.put(compte.getNumero(), compte);
        }
    }

    @Override
    public void update(Compte compte) {
        comptes.put(compte.getNumero(), compte);
    }

    @Override
    public void update(List<Compte> comptes) {
        for (Compte compte : comptes) {
            update(compte);
        }
    }

    @Override
    public void delete(Integer numero) {
        comptes.remove(numero);
    }

    @Override
    public Compte find(Integer numero) {
        Compte compte = new Compte();
        if (comptes.containsKey(numero)) {
            compte = comptes.get(numero);
        }
        return compte;
    }

    @Override
    public List<Compte> find(List<Integer> numeros) {
        List<Compte> comptes = new ArrayList<>();
        for (Integer numero : numeros) {
            if (this.comptes.containsKey(numero)) {
                comptes.add(this.comptes.get(numero));
            }
        }
        return comptes;
    }

    @Override
    public List<Compte> find(String titulaire) {
        List<Compte> comptes = new ArrayList<>();
        Collection<Compte> collection = this.comptes.values();
        for (Compte compte : collection) {
            if (compte.getTitulaire().equalsIgnoreCase(titulaire)) {
                comptes.add(compte);
            }
        }
        return comptes;
    }

    @Override
    public List<Compte> find(Boolean fermer) {
        List<Compte> comptes = new ArrayList<>();
        for (Compte compte : this.comptes.values()) {
            if (Objects.equals(compte.getFermer(), fermer)) {
                comptes.add(compte);
            }
        }
        return comptes;
    }
}
