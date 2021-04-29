package com.j4ltechnologies.formation.spring.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArtisteTest {

    /*private static EntityManagerFactory emf;
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
            emf.close();
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

        // Ici je met toutes les operations sur la BDD
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
        Artiste artiste = em.find(Artiste.class, 3);
        assertEquals(artiste.getEmail(), "e.alain@aston.fr");

        artiste.setPrenom("man");
        artiste.setNom("ip");
        artiste.setEmail("ip.man@aston.fr");

        tx.begin();
        em.merge(artiste);
        tx.commit();

        assertEquals(artiste.getPrenom(), "Man");
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
        assertEquals(requete.getResultList().size(), 3);
    }

    @Test
    void testFindArtisteByPrenomAndNom() {
//        Query requete = em.createQuery("select a from Artiste a where a.prenom = :prenom and a.nom = :nom");
//        requete.setParameter("prenom", "anas");
//        requete.setParameter("nom", "faour");
<<<<<<< Updated upstream
        TypedQuery<Artiste> requete = em
                .createQuery("select a from Artiste a where a.prenom = :prenom and a.nom = :nom", Artiste.class);

        requete.setParameter("nom", "ezzouch").setParameter("prenom", "wiem");

        assertNotNull(requete.getSingleResult());
        assertEquals(requete.getSingleResult().getAge(), 17);
=======
        TypedQuery<Artiste> requete = em.createQuery("select a from Artiste a where a.prenom = :prenom and a.nom = :nom", Artiste.class);
        requete
                .setParameter("nom", "ezzouch")
                .setParameter("prenom", "wiem");

        assertNotNull(requete.getResultList().get(0));
        assertEquals(requete.getResultList().get(0).getAge(), 17);
>>>>>>> Stashed changes
    }

    @Test
    void testInsertRelation() {
        Artiste vincent = new Artiste("vincent", "alex", "a.vincent@aston.fr", LocalDate.of(1999, 5, 18));
        assertNull(vincent.getId(), "L'id est null");

        Adresse adresseVincent = new Adresse("19 rue du 8 mai 1945 Arcueil");
        vincent.setAdresse(adresseVincent);

        tx.begin();
//		Adresse adresseVincent = new Adresse("19 rue du 8 mai 1945 Arcueil");
//		em.persist(adresseVincent);

//		vincent.setAdresse(adresseVincent);
        em.persist(vincent);

        tx.commit();

        assertNotNull(vincent.getId());
        assertNotNull(adresseVincent.getId());
    }*/
}
