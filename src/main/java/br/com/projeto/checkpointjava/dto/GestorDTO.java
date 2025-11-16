package br.com.projeto.checkpointjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GestorDTO {
    private String nome;
    private String email;
    private String senha;
    private Long setorID;
}
