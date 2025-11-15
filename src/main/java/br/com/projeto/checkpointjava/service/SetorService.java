package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.SetorDTO;
import br.com.projeto.checkpointjava.entity.Setor;
import br.com.projeto.checkpointjava.repository.SetorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository repository;

    public List<Setor> listar() {
        return repository.findAll();
    }

    public Setor buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado"));
    }

    public Setor criar(SetorDTO dto) {
        Setor setor = Setor.builder()
                .nome_setor(dto.nome_setor())
                .descricao(dto.descricao())
                .build();

        return repository.save(setor);
    }

    public Setor atualizar(Long id, SetorDTO dto) {
        Setor setor = buscar(id);

        setor.setNome_setor(dto.nome_setor());
        setor.setDescricao(dto.descricao());

        return repository.save(setor);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado");
        }
        repository.deleteById(id);
    }
}
