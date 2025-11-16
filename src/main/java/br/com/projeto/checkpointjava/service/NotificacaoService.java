package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.NotificacaoDTO;
import br.com.projeto.checkpointjava.entity.Notificacao;
import br.com.projeto.checkpointjava.entity.Usuario;
import br.com.projeto.checkpointjava.repository.NotificacaoRepository;
import br.com.projeto.checkpointjava.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public Notificacao criar(NotificacaoDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        Notificacao notificacao = Notificacao.builder()
                .usuario(usuario)
                .titulo(dto.getTitulo())
                .mensagem(dto.getMensagem())
                .tipo(dto.getTipo())
                .data_envio(LocalDateTime.now())
                .visualizado(false)
                .build();

        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listar() {
        return notificacaoRepository.findAll();
    }

    public Notificacao buscar(Long id) {
        return notificacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notificação não encontrada"));
    }

    public void marcarComoLida(Long id) {
        Notificacao notif = buscar(id);
        notif.setVisualizado(true);
        notificacaoRepository.save(notif);
    }

    public void deletar(Long id) {
        notificacaoRepository.deleteById(id);
    }
}
