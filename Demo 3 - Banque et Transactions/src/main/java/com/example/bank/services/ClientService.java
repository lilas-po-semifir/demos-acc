package com.example.bank.services;

import com.example.bank.entities.Client;
import com.example.bank.entities.Compte;
import com.example.bank.repositories.ClientRepository;
import com.example.bank.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
  private final ClientRepository clientRepository;
  private final CompteRepository compteRepository;

  public ClientService(ClientRepository clientRepository, CompteRepository compteRepository){
    this.clientRepository = clientRepository;
    this.compteRepository = compteRepository;
  }

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Client getClientById(int id){
    return clientRepository.findById(id).orElseThrow(
        //TODO: Add exception
    );
  }

  public Client saveClient(Client client){
    //TODO: Check if client doesn't already exists
    return clientRepository.save(client);
  }

  public void deleteClientById(int id){
    //TODO: Check if client still has accounts
    clientRepository.deleteById(id);
  }

  public Client ajouterCompteAClient(int idClient, int idCompte){
    Client client = getClientById(idClient);
    Compte compte = compteRepository.findById(idCompte).orElseThrow();
    client.getComptes().add(compte);
    return saveClient(client);
  }
}
