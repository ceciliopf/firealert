package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Alert;
import web.firealert.service.AlertService;

import java.util.List;

@Controller
@RequestMapping("/alertas")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> listarAlertas() {
        return alertService.listarTodos();
    }


    @PostMapping("/floresta/{idFloresta}")
    public Alert criarAlerta(@RequestBody Alert alert, @PathVariable Long idFloresta) {
        return alertService.criarAlerta(alert, idFloresta);
    }
}