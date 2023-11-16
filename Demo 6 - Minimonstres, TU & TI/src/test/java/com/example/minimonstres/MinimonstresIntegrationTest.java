package com.example.minimonstres;

import com.example.minimonstres.models.Minimonstre;
import com.example.minimonstres.models.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MinimonstresIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MinimonstreService minimonstreService;

  @MockBean
  private MinimonstreRepository minimonstreRepository;

  @Test
  public void TestIntegrationScenario() throws Exception{
    Minimonstre bulbizarre = Minimonstre.builder()
        .id(1)
        .type(Type.PLANTE)
        .nom("Bulbizarre")
        .degats(30)
        .vie(130)
        .vitesse(25)
        .build();

    Mockito.when(minimonstreService.getMinimonstreById(1))
        .thenReturn(bulbizarre);

    Mockito.when(minimonstreRepository.save(Mockito.any(Minimonstre.class))).thenReturn(bulbizarre);

    ObjectMapper objectMapper = new ObjectMapper();
    String bulbizarreJson = objectMapper.writeValueAsString(bulbizarre);

    mockMvc
        .perform(MockMvcRequestBuilders
            .get("/api/minimonstres/1")
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(
            MockMvcResultMatchers.status().isOk()
        )
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.nom").value("Bulbizarre")
        );
  }
}
