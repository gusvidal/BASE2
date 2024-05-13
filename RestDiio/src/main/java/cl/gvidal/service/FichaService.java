package cl.gvidal.service;

import cl.gvidal.model.Ficha;
import cl.gvidal.repository.FichaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FichaService implements IFichaService{

    @Autowired
    private FichaDao repository;

    @Override
    public List<Ficha> listar() {

        return (List<Ficha>) repository.findAll();
    }

    @Override
    public List<Ficha> listarPorDiio(int id) {
        return repository.findByDiioId(id);
    }

    @Override
    public int save(Ficha f) {
        int result=0;
		Ficha ficha=repository.save(f);
		if(!ficha.equals(null)) {
			result=1;
		}
		return result;
    }

    @Override
    public void delete(int id) {

        repository.deleteById(id);
    }

    @Override
    public Optional<Ficha> fichaPorId(int id) {
        return repository.findById(id);
    }
}
