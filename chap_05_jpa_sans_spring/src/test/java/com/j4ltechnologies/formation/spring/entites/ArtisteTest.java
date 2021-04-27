package com.j4ltechnologies.formation.spring.entites;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtisteTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("MYSQL_ASTON_PU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @AfterAll
    static void detroy() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            em.close();
        }
    }

    @Test
    void testPersistArtist() {

        Artiste marie = new Artiste("marie", "demolin", "d.marie@aston.fr", LocalDate.of(1999, 5, 18));
        assertNull(marie.getId(), "L'id est null");

        Artiste wiem = new Artiste("wiem", "ezzouch", "e.wiem@aston.fr", LocalDate.of(2003, 4, 28));
        assertNull(wiem.getId(), "L'id est null");

        Artiste alain = new Artiste("alain", "elbaz", "e.alain@aston.fr", LocalDate.of(1990, 2, 2));
        assertNull(wiem.getId(), "L'id est null");

        tx.begin();

        //Ici je met toutes les operations sur la BDD
        em.persist(marie);
        em.persist(wiem);
        em.persist(alain);

        tx.commit();

        assertEquals(marie.getId(), 1);
        assertEquals(wiem.getId(), 2);
        assertEquals(alain.getId(), 3);
    }

    @Test
    void testFindMergeArtiste() {
        Artiste artiste = em.find(Artiste.class, 6);
        assertEquals(artiste.getEmail(), "bruce.lee@aston.fr");

        artiste.setPrenom("man");
        artiste.setNom("ip");

        tx.begin();
        em.merge(artiste);
        tx.commit();

        assertEquals(artiste.getPrenom(), "man");
    }

    @Test
    void testRemoveArtiste() {
        Artiste artiste = em.find(Artiste.class, 8);
        assertEquals(artiste.getEmail(), "bruce.lee@aston.fr");

        tx.begin();
        em.remove(artiste);
        tx.commit();

        artiste = em.find(Artiste.class, 8);
        assertNull(artiste);
    }

    @Test
    void testFindAllArtistes() {
        Query requete = em.createQuery("select a from Artiste a");
        assertEquals(requete.getResultList().size(), 2);
    }

    @Test
    void testFindArtisteByPrenomAndNom() {
        Query requete = em.createQuery("select a from Artiste a where a.prenom = :prenom and a.nom = :nom", Artiste.class);
//        requete.setParameter("prenom", "anas");
//        requete.setParameter("nom", "faour");
        requete
                .setParameter("nom", "ezzouch")
                .setParameter("prenom", "wiem");

        assertNotNull(requete.getSingleResult());
        assertEquals(((Artiste)requete.getSingleResult()).getAge(), 17);
    }
}
