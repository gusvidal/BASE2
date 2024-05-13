package cl.gvidal.repository;

import cl.gvidal.model.Ficha;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface FichaDao extends CrudRepository<Ficha, Integer>{
    @Query(value = "SELECT f.ficha_id,f.fecha_atencion,f.diagnostico,f.indicaciones,f.medico_tratante,f.diio_id FROM ficha f where f.diio_id =?1", nativeQuery = true)
    List<Ficha> findByDiioId(int id);
}
