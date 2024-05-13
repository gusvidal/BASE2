package cl.gvidal.service;

import cl.gvidal.model.Ficha;

import java.util.List;
import java.util.Optional;

public interface IFichaService {
    public List<Ficha> listar();
	public List<Ficha> listarPorDiio(int id);

	public int save(Ficha f);

	public void delete(int id);

	public Optional<Ficha> fichaPorId(int id);
}
