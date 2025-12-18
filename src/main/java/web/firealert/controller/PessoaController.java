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
import web.firealert.model.Pessoa;
import web.firealert.service.FlorestaService;
import web.firealert.service.PessoaService;

import java.util.List;



@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private FlorestaService florestaService;


    @GetMapping
    public String listar(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("nome").ascending());
        
        Page<Pessoa> pagePessoas = pessoaService.listarPaginado(pageable);
        
        model.addAttribute("pagePessoas", pagePessoas); 
        return "pessoas/pesquisar";
    }

    @GetMapping("/cadastrar")
    public String abrirCadastro(Model model) {
        model.addAttribute("pessoa", new Pessoa());

        model.addAttribute("florestas", florestaService.listarTodas());



        return "pessoas/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarCadastro(@Valid Pessoa pessoa, BindingResult result, Model model ) {

        if (result.hasErrors()) {
            model.addAttribute("florestas", florestaService.listarTodas());
            return "pessoas/cadastrar";
        }

        pessoaService.cadastrarGuarda(pessoa);
        
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable("codigo") Long codigo, Model model) {
        Pessoa p = pessoaService.buscarPorId(codigo);
        model.addAttribute("pessoa", p);
        
        model.addAttribute("florestas", florestaService.listarTodas());
        
        return "pessoas/cadastrar"; 
    }


    @PostMapping("/excluir/{codigo}")
    public String excluir(@PathVariable("codigo") Long codigo) {
        pessoaService.excluir(codigo);
        return "redirect:/pessoas";
    }
    
    @GetMapping("/visualizar/{codigo}")
    public String visualizar(@PathVariable("codigo") Long codigo, Model model) {
        Pessoa p = pessoaService.buscarPorId(codigo);
        model.addAttribute("pessoa", p);
        
        model.addAttribute("florestas", florestaService.listarTodas());
        
        return "pessoas/visualizar";
    }
    
}