package web.firealert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.firealert.model.Floresta;
import web.firealert.model.Pessoa;
import web.firealert.repository.FlorestaRepository;
import web.firealert.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private FlorestaRepository florestaRepository;

    public Pessoa cadastrarGuarda(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }
}