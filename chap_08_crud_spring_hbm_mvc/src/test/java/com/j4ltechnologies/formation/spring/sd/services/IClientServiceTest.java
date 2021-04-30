package com.j4ltechnologies.formation.spring.sd.services;

import com.j4ltechnologies.formation.spring.sd.SpringAppConfig;
import com.j4ltechnologies.formation.spring.sd.domains.Adresse;
import com.j4ltechnologies.formation.spring.sd.domains.Client;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe IClientServiceTest, créée le 30/04/2021 à 11:00
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringAppConfig.class)
class IClientServiceTest {

    @Autowired
    IClientService service;

    private void populate() {
        Client client1 = new Client("Wiem", "wiem@aston.fr");
        Adresse adresse1 = new Adresse("8 mai 1945");
        client1.setAdresse(adresse1);

        service.addClient(client1);

        Client client2 = new Client("Paterne", "paterne@aston.fr");
        Adresse adresse2 = new Adresse("8 mai 1945");
        client2.setAdresse(adresse2);
        service.addClient(client2);

        Client client3 = new Client("Lucie", "lucie@aston.fr");
        Adresse adresse3 = new Adresse("Ludovic Guilli");
        client3.setAdresse(adresse3);
        service.addClient(client3);
    }

    @Test
    void testInject() {
        assertNotNull(service);
    }

    @BeforeAll
    static void avantTousLesTest() {
        System.out.println("\n== Debut des test unitaires ==\n");
    }

    @AfterAll
    static void apresTousLesTest() {
        System.out.println("\n== Fin des test unitaires ==\n");
    }

    @BeforeEach
    void avantChaqueTest(TestInfo info) {
        System.out.println("\nDebut du test ==> " + info.getDisplayName() + "\n");
        Persistence.generateSchema("SPRING_JEE_PU", null);
        populate();
    }

    @AfterEach
    void tearDown(TestInfo info) {
        System.out.println("\nFin du test ==> " + info.getDisplayName() + "\n");
    }


    @Test
    void testAddClient() {
        Client client = new Client("Joachim", "joachim@aston.fr");
        Adresse adresse = new Adresse("8 mai 1945");

        client.setAdresse(adresse);

        assertNull(client.getId());

        service.addClient(client);

        assertNotNull(client.getId());
        assertEquals(client.getId(), 1);
    }

    @Test
    void allClients() {
        assertNotNull(service.allClients());
        assertEquals(service.allClients().size(), 3);
    }

    @Test
    void findClientByid() {
        assertNotNull(service.findClientByid(2));
        assertEquals(service.findClientByid(2).getEmail(),"paterne@aston.fr");
    }

    @Test
    void findClientByEmail() {
        assertNotNull(service.findClientByEmail("wiem@aston.fr"));
        assertEquals(service.findClientByid(1).getPrenom(),"Wiem");
    }
}