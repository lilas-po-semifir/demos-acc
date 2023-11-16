package com.example.minimonstres;

import com.example.minimonstres.exceptions.MinimonstreNotFound;
import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/minimonstres")
@RequiredArgsConstructor
public class MinimonstreController {

  private final MinimonstreService minimonstreService;

  @GetMapping("")
  public List<Minimonstre> getAllMinimonstres() {
    return minimonstreService.getAllMinimonstres();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Minimonstre> getMinimonstreById(@PathVariable Integer id) {
    try {
      Minimonstre minimonstre = minimonstreService.getMinimonstreById(id);
      return new ResponseEntity<>(minimonstre, HttpStatus.OK);
    } catch (MinimonstreNotFound e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/type/{type}")
  public List<Minimonstre> getAllMinimonstresOfType(@PathVariable Type type) {
    return minimonstreService.getAllMinimonstresOfType(type);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Minimonstre> patchMinimonstre(@PathVariable Integer id, @RequestBody Minimonstre minimonstre) {
    try {
      Minimonstre updatedMinimonstre = minimonstreService.patchMinimonstre(id, minimonstre);
      return new ResponseEntity<>(updatedMinimonstre, HttpStatus.OK);
    } catch (MinimonstreNotFound e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Minimonstre> putMinimonstre(@PathVariable Integer id, @RequestBody Minimonstre minimonstre) {
    try {
      Minimonstre updatedMinimonstre = minimonstreService.putMinimonstre(minimonstre);
      return new ResponseEntity<>(updatedMinimonstre, HttpStatus.OK);
    } catch (MinimonstreNotFound e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("")
  public ResponseEntity<Minimonstre> postMinimonstre(@RequestBody Minimonstre minimonstre){
    return new ResponseEntity<>(minimonstreService.postMinimonstre(minimonstre), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMinimonstre(@PathVariable Integer id) {
    try {
      minimonstreService.deleteMinimonstre(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (MinimonstreNotFound e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/fight/{idMinimonstreA}/{idMinimonstreB}")
  public ResponseEntity<String> fightMinimonstres(@PathVariable Integer idMinimonstreA, @PathVariable Integer idMinimonstreB) {
    try {
      String result = minimonstreService.fightMinimonstres(idMinimonstreA, idMinimonstreB);
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (MinimonstreNotFound e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
