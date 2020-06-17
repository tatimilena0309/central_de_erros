package com.codenation.centraldeerros.mappers;

import com.codenation.centraldeerros.dto.EventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "descricaoEvento", target = "descricaoEvento"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "origem", target = "origem"),
            @Mapping(source = "quantidade", target = "quantidade")
    })
    EventoDTO map (Evento evento);

    List<EventoDTO> map(List<Evento> eventos);

}
