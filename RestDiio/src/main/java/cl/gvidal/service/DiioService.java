package cl.gvidal.service;

import java.util.List;
import java.util.Optional;

import cl.gvidal.model.Ficha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.gvidal.model.Diio;
import cl.gvidal.repository.DiioDao;

@Service
public class DiioService implements IDiioService{

    @Autowired
    private DiioDao repository;

    @Override
    public List<Diio> listar() {
    	return (List<Diio>) repository.findAll();
    }

    @Override
    public Diio listarPorNroDiio(String nroDiio) {
        return repository.findByNroDiio(nroDiio);
    }

    @Override
    public Diio listarId(int id) {
    	Optional<Diio> arete = repository.findById(id);
    	
    	return arete.get();
		
    }

    @Override
    public int save(Diio p) {
        int result=0;
		Diio arete=repository.save(p);
		if(!arete.equals(null)) {
			result=1;
		}
		return result;
    }

    @Override
    public void delete(int id) {

        repository.deleteById(id);
    }
}
