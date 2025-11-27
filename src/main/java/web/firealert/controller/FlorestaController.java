package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Floresta;
import web.firealert.repository.FlorestaRepository;

import java.util.List;

@RestController
@RequestMapping("/florestas")
public class FlorestaController {

    @Autowired
    private FlorestaRepository florestaRepository;


    @GetMapping
    public List<Floresta> listarTodas() {
        return florestaRepository.findAll();
    }


    @PostMapping
    public Floresta criarFloresta(@RequestBody Floresta floresta) {
        return florestaRepository.save(floresta);
    }
}