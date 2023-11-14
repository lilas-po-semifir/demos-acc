package com.example.bank.controllers;

import com.example.bank.entities.Client;
import com.example.bank.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
  private final ClientService clientService;

  public ClientController(ClientService clientService){
    this.clientService = clientService;
  }

  @GetMapping("")
  public List<Client> getAllClients(){
    return clientService.getAllClients();
  }

  @GetMapping("/{id}")
  public Client getClientById(@PathVariable int id){
    return clientService.getClientById(id);
  }

  @PostMapping("")
  public Client saveClient(@RequestBody Client client){
    return clientService.saveClient(client);
  }

  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable int id){
    clientService.deleteClientById(id);
  }

  @PostMapping("/{idClient}/addCompte/{idCompte}")
  public Client ajouterCompteAClient(@PathVariable int idClient, @PathVariable int idCompte){
    return clientService.ajouterCompteAClient(idClient, idCompte);
  }
}
