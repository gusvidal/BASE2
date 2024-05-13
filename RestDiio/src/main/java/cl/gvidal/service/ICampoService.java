package cl.gvidal.service;

import cl.gvidal.model.Campo;

import java.util.List;

public interface ICampoService {
    public List<Campo> listar();
    public int save(Campo c);
    public void delete(int id);
}
