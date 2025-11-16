package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.TempoTelaDTO;
import br.com.projeto.checkpointjava.entity.TempoTela;
import br.com.projeto.checkpointjava.entity.Usuario;
import br.com.projeto.checkpointjava.repository.TempoTelaRepository;
import br.com.projeto.checkpointjava.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TempoTelaService {

    private final TempoTelaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public TempoTela iniciarSessao(TempoTelaDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        TempoTela tempo = TempoTela.builder()
                .usuario(usuario)
                .inicio_sessao(LocalDateTime.parse(dto.getInicioSessao()))
                .build();

        return repository.save(tempo);
    }

    public TempoTela finalizarSessao(Long id, TempoTelaDTO dto) {
        TempoTela tempo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));

        LocalDateTime fim = LocalDateTime.parse(dto.getFimSessao());

        tempo.setFim_sessao(fim);

        long duracao = Duration.between(tempo.getInicio_sessao(), fim).toMinutes();
        tempo.setDuracao_minutos(duracao);

        return repository.save(tempo);
    }

    public List<TempoTela> listar() {
        return repository.findAll();
    }

    public TempoTela buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
