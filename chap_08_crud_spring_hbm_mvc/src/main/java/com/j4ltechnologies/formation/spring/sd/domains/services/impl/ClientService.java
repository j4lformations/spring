package com.j4ltechnologies.formation.spring.sd.domains.services.impl;

import com.j4ltechnologies.formation.spring.sd.domains.Client;
import com.j4ltechnologies.formation.spring.sd.domains.services.IClientService;
import com.j4ltechnologies.formation.spring.sd.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe ClientService, créée le 30/04/2021 à 10:28
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Service
public class ClientService implements IClientService {

    private ClientRepository repository;

    @Override
    public List<Client> allClients() {
        return repository.findAll();
    }

    @Override
    public Client findClientByid(Integer id) {
        return repository.getById(id);
    }

    @Override
    public Client findClientByEmail(String email) {
        return repository.findClientByEmail(email);
    }
}
