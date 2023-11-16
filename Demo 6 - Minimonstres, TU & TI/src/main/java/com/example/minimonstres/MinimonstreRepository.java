package com.example.minimonstres;

import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MinimonstreRepository extends JpaRepository<Minimonstre, Integer> {
  List<Minimonstre> findMinimonstresByType(Type type);
}
