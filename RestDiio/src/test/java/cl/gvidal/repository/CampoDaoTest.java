package cl.gvidal.repository;

import cl.gvidal.model.Campo;
import cl.gvidal.repository.CampoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
@DataJpaTest
class CampoDaoTest {
    @Autowired
    private CampoDao campoDao;

    @Test
    void listar() {
        List<Campo> campos = this.campoDao.findAll();
        Assertions.assertEquals(2,campos.size());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}