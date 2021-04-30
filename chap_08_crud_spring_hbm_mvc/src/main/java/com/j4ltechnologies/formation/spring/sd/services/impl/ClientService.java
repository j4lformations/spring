package com.j4ltechnologies.formation.spring.sd.services.impl;

import com.j4ltechnologies.formation.spring.sd.domains.Client;
import com.j4ltechnologies.formation.spring.sd.services.IClientService;
import com.j4ltechnologies.formation.spring.sd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Classe ClientService, créée le 30/04/2021 à 10:28
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client findClientByid(Integer id) {
        return clientRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }
}