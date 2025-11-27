package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Pessoa;
import web.firealert.service.PessoaService;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarTodos();
    }


    @PostMapping("/floresta/{idFloresta}")
    public Pessoa criarGuarda(@RequestBody Pessoa pessoa, @PathVariable Long idFloresta) {
        return pessoaService.cadastrarGuarda(pessoa, idFloresta);
    }
}