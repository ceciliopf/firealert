package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Alert;
import web.firealert.service.AlertService;
import web.firealert.service.FlorestaService;
import web.firealert.service.PessoaService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/alertas")
public class AlertController {

    @Autowired
    private AlertService alertService;
    @Autowired
    private FlorestaService florestaService;
    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alertas", alertService.listarTodos());
        return "alerts/pesquisar";

    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("alert", new Alert());
        
        model.addAttribute("florestas", florestaService.listarTodas());

        model.addAttribute("pessoas", pessoaService.listarTodos());
        
        return "alerts/cadastrar";
    }
    
    
    
}