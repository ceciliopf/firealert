package web.firealert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.firealert.model.Alert;
import web.firealert.model.Floresta;
import web.firealert.model.Pessoa;
import web.firealert.repository.AlertRepository;
import web.firealert.repository.FlorestaRepository;
import web.firealert.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private FlorestaRepository florestaRepository;

    public Pessoa cadastrarGuarda(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Page<Pessoa> listarPaginado(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public long contarTodas() {
        return pessoaRepository.count();
    }

    public Pessoa buscarPorId(Long codigo) {
        return pessoaRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }

    public void excluir(Long codigo) {
        List<Alert> alertas = alertRepository.findByPessoaCodigo(codigo);
        
        for (Alert alerta : alertas) {
            alerta.setPessoa(null);
            alertRepository.save(alerta);
        }

        pessoaRepository.deleteById(codigo);
    }
}