package com.example.demo.controllers;

import com.example.demo.entities.Ingredient;
import com.example.demo.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
  private final IngredientService service;

  public IngredientController(IngredientService service){
    this.service = service;
  }

  @GetMapping("")
  public List<Ingredient> findAll(){
    return service.findAll();
  }

  // MEILLEURE METHODE
  // :8080/api/v1/ingredients/1

  // :8080/api/v1/ingredients?name=safran

  // :8080/api/v1/ingredients
  // +
  // { "id": 1 }

  @GetMapping("/{id}")
  public Ingredient findById(@PathVariable int id){
    return service.findById(id);
  }

  @PostMapping("")
  public Ingredient save(@RequestBody Ingredient ingredient){
    return service.save(ingredient);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable int id){
    service.deleteById(id);
  }
}
