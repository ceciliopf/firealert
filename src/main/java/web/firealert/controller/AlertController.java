package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Alert;
import web.firealert.repository.AlertRepository;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertController {

    @Autowired
    private AlertRepository alertRepository;


    @GetMapping
    public List<Alert> listarAlertas() {
        return alertRepository.findAll();
    }


    @GetMapping("/floresta/{id}")
    public List<Alert> listarPorFloresta(@PathVariable Long id) {
        return alertRepository.findByFlorestaId(id);
    }


    @PostMapping
    public Alert criarAlerta(@RequestBody Alert alert) {
        System.out.println("NOVO ALERTA RECEBIDO: " + alert.getTipo());
        return alertRepository.save(alert);
    }
}