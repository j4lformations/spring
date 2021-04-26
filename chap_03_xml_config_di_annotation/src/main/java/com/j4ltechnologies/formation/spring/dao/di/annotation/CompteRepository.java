package com.j4ltechnologies.formation.spring.dao.di.annotation;

import com.j4ltechnologies.formation.spring.dao.ICompteRepository;
import com.j4ltechnologies.formation.spring.domains.Compte;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Classe CompteRepository, créée le 26/04/2021 à 19:16
 *
 * @author Joachim Zadi
 * @version 1.0 du 26/04/2021
 */
@Component
public class CompteRepository implements ICompteRepository {

    private Map<Integer, Compte> comptes = new HashMap<>();

    // Initialisation de la map comptes via un bloc d'initialisation
    {
        Compte compte1 = new Compte(1, "Victor", 10.0);
        comptes.put(1, compte1);

        Compte compte2 = new Compte(2, "Adélie", 30.0);
        comptes.put(2, compte2);

        Compte compte3 = new Compte(3, "Julie", 50.0);
        comptes.put(3, compte3);
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
