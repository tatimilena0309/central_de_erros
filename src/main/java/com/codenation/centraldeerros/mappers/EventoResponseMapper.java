package com.codenation.centraldeerros.mappers;

import com.codenation.centraldeerros.dto.ResponseEventoDTO;
import com.codenation.centraldeerros.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoResponseMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "origem", target = "origem"),
            @Mapping(source = "quantidade", target = "quantidade")
    })
    ResponseEventoDTO map(Evento evento);

    List<ResponseEventoDTO> map(List<Evento> eventos);

}
