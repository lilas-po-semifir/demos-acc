package com.example.minimonstres;

import com.example.minimonstres.exceptions.MinimonstreNotFound;
import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MinimonstreService {

  private final MinimonstreRepository minimonstreRepository;

  //GetAll
  public List<Minimonstre> getAllMinimonstres(){
    return minimonstreRepository.findAll();
  }

  //GetById
  public Minimonstre getMinimonstreById(Integer id) throws MinimonstreNotFound {
    return minimonstreRepository.findById(id).orElseThrow(
        () -> new MinimonstreNotFound("Aucun Minimonstre avec l'ID "+ id +" n'a été trouvé."));
  }

  //GetByType
  public List<Minimonstre> getAllMinimonstresOfType(Type type){
    return minimonstreRepository.findMinimonstresByType(type);
  }

  //Patch
  public Minimonstre patchMinimonstre(Integer id, Minimonstre minimonstre) throws MinimonstreNotFound {
    Minimonstre minimonstreActuel = getMinimonstreById(id);
    minimonstreActuel.setType(minimonstre.getType() != null ? minimonstre.getType() : minimonstreActuel.getType());
    minimonstreActuel.setNom(minimonstre.getNom() != null ? minimonstre.getNom() : minimonstreActuel.getNom());
    minimonstreActuel.setVitesse(
        minimonstre.getVitesse() != null ? minimonstre.getVitesse() : minimonstreActuel.getVitesse()
    );
    minimonstreActuel.setVie(minimonstre.getVie() != null ? minimonstre.getVie() : minimonstreActuel.getVie());
    minimonstreActuel.setDegats(
        minimonstre.getDegats() != null ? minimonstre.getDegats() : minimonstreActuel.getDegats()
    );

    return minimonstreRepository.save(minimonstreActuel);
  }

  //Put
  public Minimonstre putMinimonstre(Minimonstre minimonstre) throws MinimonstreNotFound {
    Minimonstre minimonstreActuel = getMinimonstreById(minimonstre.getId());
    minimonstreActuel.setNom(minimonstre.getNom());
    minimonstreActuel.setType(minimonstre.getType());
    minimonstreActuel.setVitesse(minimonstre.getVitesse());
    minimonstreActuel.setVie(minimonstre.getVie());
    minimonstreActuel.setDegats(minimonstre.getDegats());

    return minimonstreRepository.save(minimonstreActuel);
  }

  //Post
  public Minimonstre postMinimonstre(Minimonstre minimonstre){
    return minimonstreRepository.save(minimonstre);
  }

  //Delete
  public void deleteMinimonstre(Integer id) throws MinimonstreNotFound {
    getMinimonstreById(id);
    minimonstreRepository.deleteById(id);
  }

  //Get Forces
  public Type getForceOfMinimonstre(Minimonstre minimonstre){
    switch (minimonstre.getType()) {
      case EAU -> {
        return Type.FEU;
      }
      case FEU -> {
        return Type.PLANTE;
      }
      case PLANTE -> {
        return Type.EAU;
      }
    }
    return null;
  }

  //Fight
  public String fightMinimonstres(Integer idMinimonstreA, Integer idMinimonstreB) throws MinimonstreNotFound {
    Minimonstre minimonstreA = getMinimonstreById(idMinimonstreA);
    Minimonstre minimonstreB = getMinimonstreById(idMinimonstreB);
    Minimonstre gagnant = null;

    while (minimonstreA.getVie() > 0 && minimonstreB.getVie() > 0) {
      Minimonstre attaquant, defenseur;

      if (minimonstreA.getVitesse() > minimonstreB.getVitesse()) {
        attaquant = minimonstreA;
        defenseur = minimonstreB;
      } else {
        attaquant = minimonstreB;
        defenseur = minimonstreA;
      }

      int degatsInfliges = (getForceOfMinimonstre(attaquant) == defenseur.getType()) ?
          attaquant.getDegats() * 2 :
          attaquant.getDegats();

      defenseur.setVie(defenseur.getVie() - degatsInfliges);

      if (defenseur.getVie() <= 0) {
        gagnant = attaquant;
        break;
      }
    }

    if (gagnant != null) {
      return "Le minimonstre " + gagnant.getNom() + " a gagné avec " + gagnant.getVie() + "HP restants!";
    } else {
      return "La bataille s'est terminée sans vainqueur.";
    }

  }
}
