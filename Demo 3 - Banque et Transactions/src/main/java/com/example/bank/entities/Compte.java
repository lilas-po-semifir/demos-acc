package com.example.bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compte {

  public Compte(){

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nom;
  private float solde;
  private float limitDette;

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

  public float getSolde() {
    return solde;
  }

  public void setSolde(float solde) {
    this.solde = solde;
  }

  public float getLimitDette() {
    return limitDette;
  }

  public void setLimitDette(float limitDette) {
    this.limitDette = limitDette;
  }
}
