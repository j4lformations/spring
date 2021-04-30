package com.j4ltechnologies.formation.spring.sd.domains;

import javax.persistence.*;

/**
 * Classe Client, créée le 30/04/2021 à 10:17
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Adresse adresse;

    public Client(String prenom, String email) {
        this.prenom = prenom;
        this.email = email;
        adresse = new Adresse();
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
