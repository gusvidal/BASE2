package cl.gvidal.repository;

import cl.gvidal.model.Campo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoDao extends CrudRepository<Campo, Integer> {
}
