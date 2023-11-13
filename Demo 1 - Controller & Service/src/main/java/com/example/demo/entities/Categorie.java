package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categorie {

  public Categorie(){

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false, unique = true)
  private String nom;

  @ManyToMany
  @JoinTable(
      name = "categories_recettes",
      joinColumns = @JoinColumn(name = "categorie_id"),
      inverseJoinColumns = @JoinColumn(name = "recettes_id")
  )
  private List<Recette> recettes;

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

  public List<Recette> getRecettes() {
    return recettes;
  }

  public void setRecettes(List<Recette> recettes) {
    this.recettes = recettes;
  }
}
