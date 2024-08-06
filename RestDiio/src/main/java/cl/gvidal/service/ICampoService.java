package cl.gvidal.service;

import cl.gvidal.model.Campo;

import java.util.List;
import java.util.Optional;

public interface ICampoService {
    public List<Campo> listar();
    public Optional<Campo> CampoById(int id);
    public int save(Campo c);
    public void delete(int id);
}
