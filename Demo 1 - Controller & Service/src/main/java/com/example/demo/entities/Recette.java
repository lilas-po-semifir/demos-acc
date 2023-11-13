package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recette {

  public Recette(){

  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String description;

  @OneToMany
  public List<IngredientQuantite> ingredientQuantite;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<IngredientQuantite> getIngredientQuantite() {
    return ingredientQuantite;
  }

  public void setIngredientQuantite(List<IngredientQuantite> ingredientQuantite) {
    this.ingredientQuantite = ingredientQuantite;
  }
}
