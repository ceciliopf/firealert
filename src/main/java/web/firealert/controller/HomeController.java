package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.firealert.service.AlertService;
import web.firealert.service.FlorestaService;
import web.firealert.service.PessoaService;


@Controller
public class HomeController {
    
    @Autowired
    private FlorestaService florestaService;
    @Autowired
    private AlertService alertService;
    @Autowired
    private PessoaService pessoaService;



    @GetMapping("/")
    public String index (Model model) {

        long totalFlorestas = florestaService.contarTodas();
        long alertasAtivos = alertService.contarAlertasAtivos();
        long totalBrigadistas = pessoaService.contarTodas();

        model.addAttribute("totalFlorestas", totalFlorestas);
        model.addAttribute("alertasAtivos", alertasAtivos);
        model.addAttribute("totalBrigadistas", totalBrigadistas);

        return "index";
    }
    
}
