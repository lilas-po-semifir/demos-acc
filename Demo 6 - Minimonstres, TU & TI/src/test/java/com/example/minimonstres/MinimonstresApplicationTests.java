package com.example.minimonstres;

import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MinimonstresApplicationTests {

  @Test
  public void MinimonstreService_getForceOfMinimonstre_TU(){
    //Arrange
    MinimonstreRepository minimonstreRepository = Mockito.mock(MinimonstreRepository.class);
    MinimonstreService minimonstreService = new MinimonstreService(minimonstreRepository);

    Minimonstre bulbizarre = Minimonstre.builder().id(1).type(Type.PLANTE).nom("Bulbizarre").build();
    Minimonstre salameche = Minimonstre.builder().id(2).type(Type.FEU).nom("Salamèche").build();
    Minimonstre carapuce = Minimonstre.builder().id(3).type(Type.EAU).nom("Carapuce").build();
    Minimonstre miaouss = Minimonstre.builder().id(4).type(Type.NEUTRE).nom("Miaouss").build();

    //Act
    //Assert
    Assertions.assertEquals(Type.EAU, minimonstreService.getForceOfMinimonstre(bulbizarre));
    Assertions.assertEquals(Type.PLANTE, minimonstreService.getForceOfMinimonstre(salameche));
    Assertions.assertEquals(Type.FEU, minimonstreService.getForceOfMinimonstre(carapuce));
    Assertions.assertNull(minimonstreService.getForceOfMinimonstre(miaouss));
  }

}
