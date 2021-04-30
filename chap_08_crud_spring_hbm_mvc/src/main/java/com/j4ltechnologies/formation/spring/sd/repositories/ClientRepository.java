package com.j4ltechnologies.formation.spring.sd.repositories;

import com.j4ltechnologies.formation.spring.sd.domains.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe ClientRepository, créée le 30/04/2021 à 10:25
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientByEmail(String email);
}