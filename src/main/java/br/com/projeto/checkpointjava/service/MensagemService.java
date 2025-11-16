package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.entity.Mensagem;
import br.com.projeto.checkpointjava.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem salvar(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> listar() {
        return mensagemRepository.findAll();
    }

    public Mensagem buscarPorId(Long id) {
        return mensagemRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        mensagemRepository.deleteById(id);
    }
}
