package com.j4ltechnologies.formation.spring.sd.domains.services;

import com.j4ltechnologies.formation.spring.sd.domains.Client;

import java.util.List;

/**
 * Classe IClientService, créée le 30/04/2021 à 10:26
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
public interface IClientService {
    List<Client> allClients();
    Client findClientByid(Integer id);
    Client findClientByEmail(String email);
}
