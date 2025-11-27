package web.firealert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.firealert.model.Floresta;
import web.firealert.repository.FlorestaRepository;

import java.util.List;

@Service
public class FlorestaService {

    @Autowired
    private FlorestaRepository florestaRepository;

    public List<Floresta> listarTodas() {
        return florestaRepository.findAll();
    }

    public Floresta salvar(Floresta floresta) {

        return florestaRepository.save(floresta);
    }

    public Floresta buscarPorId(Long id) {
        return florestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floresta não encontrada!"));
    }
}