package br.com.projeto.checkpointjava.controller;

import br.com.projeto.checkpointjava.dto.TempoTelaDTO;
import br.com.projeto.checkpointjava.entity.TempoTela;
import br.com.projeto.checkpointjava.service.TempoTelaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tempo-tela")
@RequiredArgsConstructor
public class TempoTelaController {

    private final TempoTelaService service;

    @GetMapping
    public List<TempoTela> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TempoTela buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping("/inicio")
    public ResponseEntity<TempoTela> iniciar(@RequestBody TempoTelaDTO dto) {
        return ResponseEntity.status(201).body(service.iniciarSessao(dto));
    }

    @PutMapping("/fim/{id}")
    public ResponseEntity<TempoTela> finalizar(@PathVariable Long id, @RequestBody TempoTelaDTO dto) {
        return ResponseEntity.ok(service.finalizarSessao(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
