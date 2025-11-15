package br.com.projeto.checkpointjava.controller;

import br.com.projeto.checkpointjava.dto.HistoricoBemEstarDTO;
import br.com.projeto.checkpointjava.entity.HistoricoBemEstar;
import br.com.projeto.checkpointjava.service.HistoricoBemEstarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicos")
@RequiredArgsConstructor
public class HistoricoBemEstarController {

    private final HistoricoBemEstarService service;

    // Criar
    @PostMapping
    public ResponseEntity<HistoricoBemEstar> criar(@RequestBody @Valid HistoricoBemEstarDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    // Listar tudo
    @GetMapping
    public ResponseEntity<List<HistoricoBemEstar>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<HistoricoBemEstar> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
