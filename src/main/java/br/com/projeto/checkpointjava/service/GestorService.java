package br.com.projeto.checkpointjava.service;

import br.com.projeto.checkpointjava.dto.GestorDTO;
import br.com.projeto.checkpointjava.entity.Gestor;
import br.com.projeto.checkpointjava.entity.Setor;
import br.com.projeto.checkpointjava.repository.GestorRepository;
import br.com.projeto.checkpointjava.repository.SetorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GestorService {

    private final GestorRepository repository;
    private final SetorRepository setorRepository;

    public List<Gestor> listar() {
        return repository.findAll();
    }

    public Gestor buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Gestor não encontrado"));
    }

    public Gestor criar(GestorDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }

        Setor setor = setorRepository.findById(dto.getSetorId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Setor não encontrado"));

        Gestor gestor = Gestor.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .setor(setor)
                .build();

        return repository.save(gestor);
    }

    public Gestor atualizar(Long id, GestorDTO dto) {
        Gestor gestor = buscar(id);

        gestor.setNome(dto.getNome());
        gestor.setEmail(dto.getEmail());
        gestor.setSenha(dto.getSenha());

        if (dto.getSetorId() != null) {
            Setor setor = setorRepository.findById(dto.getSetorId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Setor não encontrado"));

            gestor.setSetor(setor);
        }

        return repository.save(gestor);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gestor não encontrado");
        }
        repository.deleteById(id);
    }
}
