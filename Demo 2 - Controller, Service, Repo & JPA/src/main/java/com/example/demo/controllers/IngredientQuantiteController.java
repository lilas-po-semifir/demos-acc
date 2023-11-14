package com.example.demo.controllers;

import com.example.demo.entities.IngredientQuantite;
import com.example.demo.services.IngredientQuantiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientquantite")
public class IngredientQuantiteController {
  private final IngredientQuantiteService service;

  public IngredientQuantiteController(IngredientQuantiteService service){
    this.service = service;
  }

  @GetMapping("")
  public List<IngredientQuantite> findAll(){
    return service.findAll();
  }

  @GetMapping("/{id}")
  public IngredientQuantite findById(@PathVariable int id){
    return service.findById(id);
  }

  @PostMapping("")
  public IngredientQuantite save(@RequestBody IngredientQuantite ingredientQuantite){
    return service.save(ingredientQuantite);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable int id){
    service.deleteById(id);
  }
}
