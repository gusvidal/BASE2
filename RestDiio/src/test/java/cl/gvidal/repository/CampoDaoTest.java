package cl.gvidal.repository;

import cl.gvidal.model.Campo;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CampoDaoTest {

    @Autowired
    CampoDao repository;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Campo campo = Campo.builder()
                .rup("10.1.06.2658")
                .direccion("Planchado los indios Km 1")
                .build();
        entityManager.persist(campo);
    }

    @Test
    public void FindById(){
        Optional<Campo> campoRepo = repository.findById(1);
        assertEquals(campoRepo.get().getRup(),"10.1.06.2658");
        System.out.println("Campo.get: " + campoRepo.get());
    }

    @Test
    public void FindNoneById(){
        Optional<Campo> campoRepo = repository.findById(10);
        assertEquals(campoRepo, Optional.empty());
    }
}