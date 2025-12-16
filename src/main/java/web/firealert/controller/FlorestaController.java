package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Floresta;
import web.firealert.service.FlorestaService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/florestas")
public class FlorestaController {

    @Autowired
    private FlorestaService florestaService;


    @GetMapping
    public String abrirPesquisa(Model model) {
        List<Floresta> list = florestaService.listarTodas();

        model.addAttribute(list);

        return "florestas/pesquisar";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("floresta", new Floresta());

        return "florestas/cadastrar";
    }
    
    


    @GetMapping("/{id}")
    public Floresta buscarPorId(@PathVariable Long id) {
        return florestaService.buscarPorId(id);
    }
}