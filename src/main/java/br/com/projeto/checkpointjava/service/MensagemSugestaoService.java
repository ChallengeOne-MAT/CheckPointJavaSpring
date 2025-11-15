package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.MensagemSugestaoDTO;
import br.com.projeto.checkpointjava.service.MensagemSugestaoService;
import br.com.projeto.checkpointjava.entity.MensagemSugestao;
import br.com.projeto.checkpointjava.repository.MensagemSugestaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MensagemSugestaoService {

    private final MensagemSugestaoRepository repository;

    public MensagemSugestao criar(MensagemSugestaoDTO dto) {
        MensagemSugestao m = new MensagemSugestao();
        m.setDescricao(dto.getDescricao());
        m.setTipo(dto.getTipo());
        m.setNivelEstresseMinimo(dto.getNivelEstresseMinimo());
        return repository.save(m);
    }

    public List<MensagemSugestao> listar() {
        return repository.findAll();
    }

    public MensagemSugestao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada"));
    }

    public MensagemSugestao atualizar(Long id, MensagemSugestaoDTO dto) {
        MensagemSugestao existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada"));

        existente.setDescricao(dto.getDescricao());
        existente.setTipo(dto.getTipo());
        existente.setNivelEstresseMinimo(dto.getNivelEstresseMinimo());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada");
        repository.deleteById(id);
    }
}


