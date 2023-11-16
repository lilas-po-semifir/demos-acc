package com.example.minimonstres;

import com.example.minimonstres.exceptions.MinimonstreNotFound;
import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MinimonstreController.class)
public class MinimonstreControllerTest {

  @MockBean
  private MinimonstreService minimonstreServiceMock;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetMinimonstreById() throws Exception {
    //Arrange
    Minimonstre bulbizarre = Minimonstre.builder().id(1).type(Type.PLANTE).nom("Bulbizarre").build();
    Mockito.when(minimonstreServiceMock.getMinimonstreById(1)).thenReturn(bulbizarre);

    mockMvc
        //Act
        .perform(MockMvcRequestBuilders
            .get("/api/minimonstres/1")
            .contentType(MediaType.APPLICATION_JSON)
        )
        //Assert
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Bulbizarre"));
  }

  @Test
  public void testCreateMinimonstre() throws Exception{
    //Arrange
    Minimonstre bulbizarre = Minimonstre.builder()
        .id(1)
        .type(Type.PLANTE)
        .nom("Bulbizarre")
        .degats(30)
        .vie(130)
        .vitesse(25)
        .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String bulbizarreJson = objectMapper.writeValueAsString(bulbizarre);

    Mockito.when(
        minimonstreServiceMock.postMinimonstre(Mockito.any(Minimonstre.class))
    ).thenReturn(bulbizarre);

    mockMvc
        //Act
        .perform(MockMvcRequestBuilders
            .post("/api/minimonstres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(bulbizarreJson)
        )
        //Assert
        .andExpect(
            MockMvcResultMatchers.status().isOk()
        )
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.nom").value("Bulbizarre")
        );
  }
}
