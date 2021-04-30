package com.j4ltechnologies.formation.spring.orm.jee.services;

import com.j4ltechnologies.formation.spring.orm.jee.AppConfig;
import com.j4ltechnologies.formation.spring.orm.jee.domains.Auteur;
import com.j4ltechnologies.formation.spring.orm.jee.domains.Livre;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe IAuteurServiceTest, créée le 29/04/2021 à 14:56
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class IAuteurServiceTest {

    @Autowired
    IAuteurService service;

    private void populate() {
        Auteur claudeDelanoy = new Auteur("d.claude@aston.fr", "claude", "delanoy", LocalDate.of(1965, Month.AUGUST, 24));
        Livre livreJava = new Livre("9782416000188", "Programmer en Java", BigDecimal.valueOf(38.00));
        Livre livrePoo = new Livre("9782212118261", "S'initier à la POO", BigDecimal.valueOf(22.25));

        service.saveOrMajAuteur(claudeDelanoy, livreJava);
        service.saveOrMajAuteur(claudeDelanoy, livrePoo);

        Auteur raphaelGotter = new Auteur("g.raphael@aston.fr", "Raphaël", "Goetter", LocalDate.of(1976, Month.JANUARY, 2));
        Livre livreCss = new Livre("9782212143638", "CSS 3 Flexbox", BigDecimal.valueOf(19.90));
        service.saveOrMajAuteur(raphaelGotter, livreCss);
    }

    @BeforeAll
    static void initAll() {
        System.out.println("\n==Phase d'initialisation Générale==\n");
    }

    @BeforeEach
    void avantChaqueTest(TestInfo testInfo) {
        System.out.println("\nDébut..." + testInfo.getDisplayName() + "\n");
        Persistence.generateSchema("SPRING_HMB_PU", null);
        populate();
    }

    @AfterEach
    void apresChaqueTest(TestInfo testInfo) {
        System.out.println("\nFin..." + testInfo.getDisplayName() + "\n");
    }

    @Test
    public void testInject() {
        assertNotNull(service);
    }

    @Test
    void allAuteurs() {
        assertNotNull(service.allAuteurs());
        assertEquals(service.allAuteurs().size(), 2);
    }

    @Test
    void allLivres() {
        assertNotNull(service.allLivres());
        assertEquals(service.allLivres().size(), 3);
    }

    @Test
    void saveOrMajAuteur() {
        Auteur auteur = service.findAuteur(1);
        auteur.setNom("goncalves");
        auteur.setPrenom("antonio");
        auteur.setEmail("g.antonio@aston.fr");

        Livre livre = new Livre("9782212120387", "Java EE 5", BigDecimal.valueOf(34.15));
        service.saveOrMajAuteur(auteur, livre);
        assertEquals(livre.getTitre(),"Java EE 5");
    }

    @Test
    void testFindAuteurById() {
        Auteur auteur = service.findAuteur(2);
        assertEquals(auteur.getId(), 2);
    }

    @Test
    void testFindAuteurByPrenomAndNom() {
        Auteur auteur = service.findAuteur("claude", "delanoy");
        assertEquals(auteur.getEmail(), "d.claude@aston.fr");
    }

    @Test
    void updateAuteur() {
    }

    @Test
    void deleteAuteur() {

    }

    @AfterAll
    public static void finishAll() {
        System.out.println("\n==Phase finale Générale==\n");
    }
}