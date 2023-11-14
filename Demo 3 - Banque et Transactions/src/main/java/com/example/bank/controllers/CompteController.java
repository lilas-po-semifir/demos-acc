package com.example.bank.controllers;

import com.example.bank.entities.Client;
import com.example.bank.entities.Compte;
import com.example.bank.requests.TransfertRequest;
import com.example.bank.services.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comptes")
public class CompteController {
  private final CompteService compteService;

  public CompteController(CompteService compteService){
    this.compteService = compteService;
  }

  @GetMapping("")
  public List<Compte> getAllComptes(){
    return compteService.getAllComptes();
  }

  @GetMapping("/{id}")
  public Compte getCompteById(@PathVariable int id){
    return compteService.getCompteById(id);
  }

  @PostMapping("")
  public Compte saveCompte(@RequestBody Compte compte){
    System.out.println(compte.getNom() + compte.getSolde() + compte.getLimitDette());
    return compteService.saveCompte(compte);
  }

  @PutMapping("/{id}")
  public Compte updateCompte(@RequestBody Compte compte){
    return compteService.saveCompte(compte);
  }

  @DeleteMapping("/{id}")
  public void deleteCompte(@PathVariable int id){
    compteService.deleteCompteById(id);
  }

  @PostMapping("/transfer")
  public void transfererArgent(@RequestBody TransfertRequest request){
    compteService.transfererArgent(
        request.getIdCompteADebiter(),
        request.getIdCompteACrediter(),
        request.getMontantACrediter()
    );
  }
}
