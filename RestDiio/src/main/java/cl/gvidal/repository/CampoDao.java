package cl.gvidal.repository;

import cl.gvidal.model.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CampoDao extends JpaRepository<Campo, Integer> {
}
