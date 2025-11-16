package br.com.projeto.checkpointjava.controller;

import br.com.projeto.checkpointjava.entity.Mensagem;
import br.com.projeto.checkpointjava.service.MensagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public Mensagem criar(@RequestBody Mensagem mensagem) {
        return mensagemService.salvar(mensagem);
    }

    @GetMapping
    public List<Mensagem> listar() {
        return mensagemService.listar();
    }

    @GetMapping("/{id}")
    public Mensagem buscar(@PathVariable Long id) {
        return mensagemService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        mensagemService.deletar(id);
    }
}
