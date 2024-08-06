package cl.gvidal.service;

import java.util.List;
import cl.gvidal.model.Diio;

public interface IDiioService {
    public List<Diio> listar();

	public List<Diio> listAllPage(int page);

	public Diio listarPorNroDiio(String nroDiio);

	public Diio listarId(int id);

	public int save(Diio p);

	public void delete(int id);
}
