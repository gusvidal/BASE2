package cl.gvidal.service;

import cl.gvidal.model.Campo;
import cl.gvidal.repository.CampoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ICampoServiceTest {

    @Autowired
    private ICampoService iCampoService;

    @MockBean
    private CampoDao campoRepository;

    @BeforeEach
    void setUp() {
        Campo campo = Campo.builder()
                .id(1)
                .rup("10.1.06.2658")
                .direccion("Planchado los indios Km 1")
                .build();

        Mockito.when(campoRepository.findById(1)).thenReturn(Optional.of(campo));
    }

    @Test
    public void FindCampo(){
        String localRup = "10.1.06.2658";
        Optional<Campo> lista = iCampoService.CampoById(1);
        assertEquals(localRup, lista.get().getRup());
    }
}