package web.firealert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.firealert.model.Floresta;
import web.firealert.service.FlorestaService;

import java.util.List;

@RestController
@RequestMapping("/florestas")
public class FlorestaController {

    @Autowired
    private FlorestaService florestaService;

    @GetMapping
    public List<Floresta> listarTodas() {
        return florestaService.listarTodas();
    }

    @PostMapping
    public Floresta criarFloresta(@RequestBody Floresta floresta) {
        return florestaService.salvar(floresta);
    }


    @GetMapping("/{id}")
    public Floresta buscarPorId(@PathVariable Long id) {
        return florestaService.buscarPorId(id);
    }
}