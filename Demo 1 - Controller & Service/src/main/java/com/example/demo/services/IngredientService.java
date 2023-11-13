package com.example.demo.services;

import com.example.demo.entities.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
  private final IngredientRepository repo;

  public IngredientService(IngredientRepository repo){
    this.repo = repo;
  }

  public List<Ingredient> findAll(){
    return repo.findAll();
  }

  public Ingredient findById(int id){
    return repo.findById(id).orElseThrow(
        //TODO : throw error
    );
  }

  public Ingredient save(Ingredient ingredient){
    //TODO : Check if ingredient doesn't exist already
    return repo.save(ingredient);
  }

  public void deleteById(int id){
    repo.deleteById(id);
  }
}
