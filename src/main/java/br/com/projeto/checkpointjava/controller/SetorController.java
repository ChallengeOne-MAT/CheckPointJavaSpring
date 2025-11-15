package br.com.projeto.checkpointjava.controller;

import br.com.projeto.checkpointjava.dto.SetorDTO;
import br.com.projeto.checkpointjava.entity.Setor;
import br.com.projeto.checkpointjava.service.SetorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@RequiredArgsConstructor
public class SetorController {

    private final SetorService service;

    @GetMapping
    public List<Setor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Setor buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Setor> criar(@RequestBody SetorDTO dto) {
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    @PutMapping("/{id}")
    public Setor atualizar(@PathVariable Long id, @RequestBody SetorDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
