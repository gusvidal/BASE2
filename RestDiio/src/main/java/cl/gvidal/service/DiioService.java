package cl.gvidal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cl.gvidal.model.Diio;
import cl.gvidal.repository.DiioDao;

@Service
public class DiioService implements IDiioService{

    @Autowired
    private DiioDao repository;

    private static int REGISTROS_POR_PAGINA = 3;

    @Override
    public List<Diio> listar() {
    	return (List<Diio>) repository.findAll();
    }


    @Override
    public List<Diio> listAllPage(int page) {
        // Creo el paginador diioPage, con la pagina de inicio, la cantidad de registros por pagina y el orden de los registros.
        Pageable diioPage = PageRequest.of(page,REGISTROS_POR_PAGINA, Sort.by("fechaInstall").descending());
        List<Diio> orderList = repository.findAll(diioPage).getContent();
        long totalElements = repository.findAll(diioPage).getTotalElements();
        long totalPages = repository.findAll(diioPage).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        return orderList;
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
