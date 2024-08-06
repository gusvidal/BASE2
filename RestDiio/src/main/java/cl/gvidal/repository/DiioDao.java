package cl.gvidal.repository;

import cl.gvidal.model.Ficha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.gvidal.model.Diio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.net.ContentHandler;

@Repository
@Transactional(readOnly = true)
public interface DiioDao extends JpaRepository<Diio, Integer> {
    @Query(value = "SELECT d.campo_id, d.diio_id,d.descripcion,d.fecha_install,d.fecha_nacimiento,d.nro_diio FROM db_diio_farm.diio d where d.nro_diio=?1 limit 1", nativeQuery = true)
    Diio findByNroDiio(String nroDiio);

    //Page<Diio> findAllByPage(Pageable pageable);

}
