package com.example.demo.repositories;

import com.example.demo.entities.IngredientQuantite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientQuantiteRepository extends JpaRepository<IngredientQuantite, Integer> {
}
