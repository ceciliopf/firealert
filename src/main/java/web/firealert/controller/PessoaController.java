package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Pessoa;
import web.firealert.service.FlorestaService;
import web.firealert.service.PessoaService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private FlorestaService florestaService;


    @GetMapping
    public String abrirPesquisa(Model model) {
        model.addAttribute("listaPessoas", pessoaService.listarTodos());

        return "pessoas/pesquisar";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("pessoa", new Pessoa());

        model.addAttribute("florestas", florestaService.listarTodas());



        return "pessoas/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarCadastro(Pessoa pessoa) {
        pessoaService.cadastrarGuarda(pessoa);
        
        return "redirect:/pessoas";
    }
    
    
    
}