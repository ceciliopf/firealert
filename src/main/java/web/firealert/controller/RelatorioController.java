package web.firealert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.firealert.model.Alert;
import web.firealert.model.Status;
import web.firealert.repository.AlertRepository;
import web.firealert.service.FlorestaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/relatorios")
public class RelatorioController {
    
    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private FlorestaService florestaService;

    @GetMapping("/ocorrencias")
    public String abrirFiltro(Model model) {
        model.addAttribute("florestas", florestaService.listarTodas());
        return "relatorios/filtro";
    }
    
    @PostMapping("/gerar")
    public String gerarRelatorio(@RequestParam(required = false) Status status,
                                 @RequestParam(required = false) Long florestaId,
                                 Model model) {
        
        List<Alert> resultados;

        if (florestaId != null) {
            resultados = alertRepository.findByFlorestaId(florestaId);
            model.addAttribute("filtroAplicado", "Floresta ID: " + florestaId);
        } else if (status != null) {
            resultados = alertRepository.findByStatus(status);
            model.addAttribute("filtroAplicado", "Status: " + status);
        } else {
            resultados = alertRepository.findAll();
            model.addAttribute("filtroAplicado", "Geral (Todos os registros)");
        }

        model.addAttribute("listaAlertas", resultados);
        
        return "relatorios/imprimir";
    }
}
