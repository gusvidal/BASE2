package cl.gvidal.service;

import cl.gvidal.model.Campo;
import cl.gvidal.repository.CampoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampoService implements ICampoService{
    @Autowired
    private CampoDao campoRepository;
    @Override
    public List<Campo> listar() {

        return (List<Campo>) campoRepository.findAll();
    }

    @Override
    public Optional<Campo> CampoById(int id) {
        return campoRepository.findById(id);
    }
    @Override
    public int save(Campo c) {
        int result=0;
        Campo campo=campoRepository.save(c);
        if(!campo.equals(null)) {
            result=1;
        }
        return result;
    }

    @Override
    public void delete(int id) {
        campoRepository.deleteById(id);
    }
}
