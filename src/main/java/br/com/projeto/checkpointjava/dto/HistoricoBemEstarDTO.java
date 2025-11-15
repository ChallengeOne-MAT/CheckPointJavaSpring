package br.com.projeto.checkpointjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoricoBemEstarDTO {
    private Long usuarioId;
    private Double indiceBemEstar;
}
