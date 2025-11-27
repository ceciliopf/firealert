package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Pessoa;
import web.firealert.repository.PessoaRepository;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }
}