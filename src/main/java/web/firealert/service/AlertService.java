package web.firealert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.firealert.model.Alert;
import web.firealert.model.Floresta;
import web.firealert.model.Gravidade;
import web.firealert.model.Status;
import web.firealert.repository.AlertRepository;
import web.firealert.repository.FlorestaRepository;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private FlorestaRepository florestaRepository;

    public Alert criarAlerta(Alert alerta) {

        return alertRepository.save(alerta);
    }
    
    public Page<Alert> listarPaginado(Status status, Gravidade tipo, Pageable pageable) {
        return alertRepository.filtrar(status, tipo, pageable);
    }

    public List<Alert> listarTodos() {
        return alertRepository.findAll();
    }

    public long contarAlertasAtivos() {
        return alertRepository.countByStatusNot(Status.DONE);
    }

    public Alert buscarPorId(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado!"));
    }

    public void excluir(Long id) {
        alertRepository.deleteById(id);
    }
}