package com.j4ltechnologies.formation.spring.sd.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Adresse, créée le 30/04/2021 à 10:20
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    public Adresse(String libelle) {
        this.libelle = libelle;
    }

    public Adresse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
