package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import web.firealert.model.Alert;
import web.firealert.model.Gravidade;
import web.firealert.model.Status;
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
    public String listar(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(required = false) Status status,
                         @RequestParam(required = false) Gravidade tipo,
                         Model model) {
        
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        
        Page<Alert> pageAlerts = alertService.listarPaginado(status, tipo, pageable);
        
        model.addAttribute("pageAlerts", pageAlerts);
        
        model.addAttribute("filtroStatus", status);
        model.addAttribute("filtroTipo", tipo);
        
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
    public String salvar(@Valid Alert alert, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("florestas", florestaService.listarTodas());
            model.addAttribute("pessoas", pessoaService.listarTodos());
            
            if (alert.getId() != 0) {
                 return "alerts/visualizar"; 
            }
            return "alerts/cadastrar";
        }
        alertService.criarAlerta(alert);
        
        return "redirect:/alertas";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable("id") Long id, Model model) {
        Alert alert = alertService.buscarPorId(id);
        model.addAttribute("alert", alert);
        
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