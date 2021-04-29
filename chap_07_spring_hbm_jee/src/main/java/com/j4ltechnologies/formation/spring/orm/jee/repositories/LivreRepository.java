package com.j4ltechnologies.formation.spring.orm.jee.repositories;

import com.j4ltechnologies.formation.spring.orm.jee.domains.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe LivreRepository, créée le 29/04/2021 à 13:36
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

public interface LivreRepository extends JpaRepository<Livre, Integer> {
    Livre findByIsbn(String isbn);
}
