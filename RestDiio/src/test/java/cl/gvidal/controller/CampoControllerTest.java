package cl.gvidal.controller;

import cl.gvidal.model.Campo;
import cl.gvidal.service.ICampoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Optional;


@WebMvcTest(CampoController.class)
class CampoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICampoService service;

    private Campo campo;

    @BeforeEach
    void setUp() {
         campo = Campo.builder()
            .id(1)
            .rup("10.1.06.2568")
            .direccion("Planchado los indios")
            .build();
    }

    @Test
    public void saveCampo() throws Exception{
        Campo campoPost = Campo.builder()
                .rup("10.1.06.2568")
                .direccion("Planchado los indios")
                .build();
        Mockito.when(service.save(campoPost)).thenReturn(1);
        mockMvc.perform(post("/campo/save-campo").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"rup\": \"10.1.06.2556\",\n" +
                        "  \"direccion\": \"La Rinconada\"\n" +
                        "}"
                ))
                .andExpect(status().isOk());
    }

    @Test
    public void findCampoById() throws Exception{
        Mockito.when(service.CampoById(1)).thenReturn(Optional.ofNullable(campo));
        mockMvc.perform(get("/campo/lista/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.rup").value(campo.getRup()));
    }
}