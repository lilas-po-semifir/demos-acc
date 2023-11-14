package com.example.bank.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
  public Client(){

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nom;
  private String prenom;
  private String adresse;
  private String email;

  @OneToMany
  private List<Compte> comptes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Compte> getComptes() {
    return comptes;
  }

  public void setComptes(List<Compte> comptes) {
    this.comptes = comptes;
  }
}
