package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.FeedbackDTO;
import br.com.projeto.checkpointjava.entity.Feedback;
import br.com.projeto.checkpointjava.entity.Usuario;
import br.com.projeto.checkpointjava.repository.FeedbackRepository;
import br.com.projeto.checkpointjava.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UsuarioRepository usuarioRepository;

    public Feedback criar(FeedbackDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        Feedback feedback = new Feedback();
        feedback.setUsuario(usuario);
        feedback.setNivelEstresse(dto.getNivelEstresse());
        feedback.setHumor(dto.getHumor());
        feedback.setComentario(dto.getComentario());
        feedback.setDataFeedback(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    public List<Feedback> listar() {
        return feedbackRepository.findAll();
    }

    public Feedback buscarPorId(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback não encontrado"));
    }

    public void deletar(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback não encontrado");
        }
        feedbackRepository.deleteById(id);
    }
}
