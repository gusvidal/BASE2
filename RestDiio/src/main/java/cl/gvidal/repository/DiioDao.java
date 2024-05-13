package cl.gvidal.repository;

import cl.gvidal.model.Ficha;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.gvidal.model.Diio;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DiioDao extends CrudRepository<Diio, Integer>{
    @Query(value = "SELECT d.campo_id, d.diio_id,d.descripcion,d.fecha_install,d.fecha_nacimiento,d.nro_diio FROM db_diio_farm.diio d where d.nro_diio=?1 limit 1", nativeQuery = true)
    Diio findByNroDiio(String nroDiio);
}
