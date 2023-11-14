package com.example.bank.services;

import com.example.bank.entities.Compte;
import com.example.bank.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompteService {
  private final CompteRepository compteRepository;

  public CompteService(CompteRepository compteRepository){
    this.compteRepository = compteRepository;
  }

  public List<Compte> getAllComptes(){
    return compteRepository.findAll();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
  public Compte getCompteById(int id){
    return compteRepository.findById(id).orElseThrow(
        //TODO: Add exceptions
    );
  }

  public Compte saveCompte(Compte compte){
    return compteRepository.save(compte);
  }

  public void deleteCompteById(int id){
    compteRepository.deleteById(id);
  }

  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
  public void debiterCompte(int idCompte, long montantADebiter){
    //On récupère le compte en question
    Compte compteADebiter = getCompteById(idCompte);

    //On vérifie si le compte possède assez d'argent (ou qu'il n'est pas trop en dette
    if (compteADebiter.getSolde() - montantADebiter < compteADebiter.getLimitDette()){
      throw new RuntimeException("Solde insuffisant sur le compte");
    }

    //On retire l'argent...
    compteADebiter.setSolde(compteADebiter.getSolde() - montantADebiter);
    //Et on sauvegarde le compte.
    saveCompte(compteADebiter);
  }

  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
  public void crediterCompte(int idCompte, long montantACrediter){
    //On récupère le compte...
    Compte compteACrediter = getCompteById(idCompte);

    //...on ajoute l'argent...
    compteACrediter.setSolde(compteACrediter.getSolde() + montantACrediter);

    //...et on sauvegarde le compte.
    saveCompte(compteACrediter);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void transfererArgent(int idCompteADebiter, int idCompteACrediter, long montantACrediter){
    try{
      debiterCompte(idCompteADebiter, montantACrediter);
      System.out.println("Waiting 30s...");
      Thread.sleep(30_000);
      crediterCompte(idCompteACrediter, montantACrediter);
    } catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}
