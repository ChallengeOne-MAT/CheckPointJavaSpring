package br.com.projeto.checkpointjava.dto;

import jakarta.validation.constraints.NotBlank;

public record SetorDTO(
        @NotBlank String nome_setor,
        String descricao
) {}
