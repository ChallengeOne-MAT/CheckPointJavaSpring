package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.HistoricoBemEstarDTO;
import br.com.projeto.checkpointjava.entity.HistoricoBemEstar;
import br.com.projeto.checkpointjava.entity.Usuario;
import br.com.projeto.checkpointjava.repository.HistoricoBemEstarRepository;
import br.com.projeto.checkpointjava.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoBemEstarService {

    private final HistoricoBemEstarRepository repository;
    private final UsuarioRepository usuarioRepository;

    public HistoricoBemEstar criar(HistoricoBemEstarDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        HistoricoBemEstar historico = HistoricoBemEstar.builder()
                .usuario(usuario)
                .indiceBemEstar(dto.getIndiceBemEstar())
                .dataRegistro(LocalDate.now())
                .build();

        return repository.save(historico);
    }

    public List<HistoricoBemEstar> listar() {
        return repository.findAll();
    }

    public HistoricoBemEstar buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado"));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Histórico não encontrado");
        repository.deleteById(id);
    }
}
