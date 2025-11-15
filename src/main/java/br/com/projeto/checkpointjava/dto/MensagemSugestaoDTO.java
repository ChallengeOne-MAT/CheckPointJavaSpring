package br.com.projeto.checkpointjava.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemSugestaoDTO {

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255)
    private String descricao;

    @NotBlank(message = "Tipo é obrigatório")
    @Size(max = 50)
    private String tipo;

    @NotBlank(message = "Nível de estresse mínimo é obrigatório")
    @Size(max = 20)
    private String nivelEstresseMinimo;
}
