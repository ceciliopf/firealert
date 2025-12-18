package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Floresta;
import web.firealert.service.FlorestaService;

import java.util.List;


@Controller
@RequestMapping("/florestas")
public class FlorestaController {

    @Autowired
    private FlorestaService florestaService;


    @GetMapping
    public String abrirPesquisa(Model model) {
        List<Floresta> list = florestaService.listarTodas();

        model.addAttribute("listaFlorestas", list);

        return "florestas/pesquisar";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("floresta", new Floresta());

        return "florestas/cadastrar";
    }
    
    @PostMapping("/salvar") 
    public String salvar(Floresta floresta) {
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
        return "florestas/cadastrar"; // Reaproveita a tela de cadastro
    }

    // 2. Rota de Exclusão
    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        florestaService.excluir(id);
        return "redirect:/florestas";
    }
}