package com.example.demo.services;

import com.example.demo.entities.IngredientQuantite;
import com.example.demo.repositories.IngredientQuantiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientQuantiteService {
  private final IngredientQuantiteRepository repo;

  public IngredientQuantiteService(IngredientQuantiteRepository repo){
    this.repo = repo;
  }

  public List<IngredientQuantite> findAll(){
    return repo.findAll();
  }

  public IngredientQuantite findById(int id){
    return repo.findById(id).orElseThrow();
  }

  public IngredientQuantite save(IngredientQuantite ingredientQuantite){
    return repo.save(ingredientQuantite);
  }

  public void deleteById(int id){
    repo.deleteById(id);
  }
}
