package com.codenation.centraldeerros.dto;

import com.codenation.centraldeerros.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

    private Long id;
    private Level level;
    private String descricaoEvento;
    private String origem;
    private String data;
    private Integer quantidade;
}

