package br.com.nutricode.app.nutricode.controller;

import br.com.nutricode.app.nutricode.entity.MensagemSugestao;
import br.com.nutricode.app.nutricode.repository.MensagemSugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens-sugestoes")
public class MensagemSugestaoController {

    @Autowired
    private MensagemSugestaoRepository repository;

    @GetMapping
    public List<MensagemSugestao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public MensagemSugestao criar(@RequestBody MensagemSugestao mensagem) {
        return repository.save(mensagem);
    }

    @GetMapping("/{id}")
    public MensagemSugestao buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public MensagemSugestao atualizar(@PathVariable Long id, @RequestBody MensagemSugestao nova) {
        return repository.findById(id).map(m -> {
            m.setDescricao(nova.getDescricao());
            m.setTipo(nova.getTipo());
            m.setNivelEstresseMinimo(nova.getNivelEstresseMinimo());
            return repository.save(m);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
