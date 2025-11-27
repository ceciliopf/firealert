package web.firealert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.firealert.model.Alert;
import web.firealert.model.Floresta;
import web.firealert.repository.AlertRepository;
import web.firealert.repository.FlorestaRepository;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private FlorestaRepository florestaRepository;

    public Alert criarAlerta(Alert alerta, Long florestaId) {

        Floresta floresta = florestaRepository.findById(florestaId)
                .orElseThrow(() -> new RuntimeException("Floresta não encontrada para o ID: " + florestaId));


        alerta.setFloresta(floresta);

        System.out.println(">>> ENVIANDO EMAIL PARA AUTORIDADES SOBRE: " + alerta.getTipo());
        System.out.println(">>> LOCAL: " + floresta.getName());


        return alertRepository.save(alerta);
    }

    public List<Alert> listarTodos() {
        return alertRepository.findAll();
    }
}