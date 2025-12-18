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
        model.addAttribute("listaAlertas", alertService.listarTodos());
        return "alerts/pesquisar";

    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("alert", new Alert());
        
        model.addAttribute("florestas", florestaService.listarTodas());

        model.addAttribute("pessoas", pessoaService.listarTodos());
        
        return "alerts/cadastrar";
    }
    
    @PostMapping("/salvar")
    public String salvar(Alert alert) {

        alertService.criarAlerta(alert);
        
        return "redirect:/alertas";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable("id") Long id, Model model) {
        Alert alert = alertService.buscarPorId(id);
        model.addAttribute("alert", alert);
        
        // NOVO: Enviamos as listas para permitir a edição dos selects
        model.addAttribute("florestas", florestaService.listarTodas());
        model.addAttribute("pessoas", pessoaService.listarTodos());
        
        return "alerts/visualizar";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        alertService.excluir(id);
        return "redirect:/alertas";
    }
    
}