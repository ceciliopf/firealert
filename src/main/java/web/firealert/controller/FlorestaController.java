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
import web.firealert.model.Floresta;
import web.firealert.service.FlorestaService;

import java.util.List;


@Controller
@RequestMapping("/florestas")
public class FlorestaController {

    @Autowired
    private FlorestaService florestaService;


    @GetMapping
    public String abrirPesquisa(@RequestParam(defaultValue = "0") int page, 
                         @RequestParam(required = false) String busca, 
                         Model model) {
        
        Pageable pageable = PageRequest.of(page, 10, Sort.by("name").ascending());
        
        
        Page<Floresta> pageFlorestas = florestaService.listarPaginado(busca, pageable);
        
        model.addAttribute("pageFlorestas", pageFlorestas);
        model.addAttribute("busca", busca); 
        
        return "florestas/pesquisar";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("floresta", new Floresta());

        return "florestas/cadastrar";
    }
    
    @PostMapping("/salvar") 
    public String salvar(@Valid Floresta floresta, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "florestas/cadastrar";
        }
        
        florestaService.salvar(floresta);
        return "redirect:/florestas";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable("id") Long id, Model model) {
        Floresta floresta = florestaService.buscarPorId(id);
        model.addAttribute("floresta", floresta);
        return "florestas/visualizar";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Floresta floresta = florestaService.buscarPorId(id);
        model.addAttribute("floresta", floresta);
        return "florestas/cadastrar";
    }

    // 2. Rota de Exclusão
    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        florestaService.excluir(id);
        return "redirect:/florestas";
    }
}