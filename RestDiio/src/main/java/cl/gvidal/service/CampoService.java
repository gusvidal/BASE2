package cl.gvidal.service;

import cl.gvidal.model.Campo;
import cl.gvidal.repository.CampoDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CampoService implements ICampoService{
    @Autowired
    private CampoDao campoRepository;
    @Override
    public List<Campo> listar() {
        return (List<Campo>) campoRepository.findAll();
    }

    @Override
    public int save(Campo c) {
        int result=0;
        Campo ficha=campoRepository.save(c);
        if(!ficha.equals(null)) {
            result=1;
        }
        return result;
    }

    @Override
    public void delete(int id) {
        campoRepository.deleteById(id);
    }
}
