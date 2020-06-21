package com.codenation.centraldeerros.mappers;

import com.codenation.centraldeerros.dto.InsertEventoDTO;
import com.codenation.centraldeerros.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoInsertMapper {

    @Mappings({
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "origem", target = "origem"),
    })
    InsertEventoDTO map(Evento evento);

    List<InsertEventoDTO> map(List<Evento> eventos);

    @Mappings({
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "data", target = "data", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "origem", target = "origem"),
    })
    Evento map(InsertEventoDTO InsertEventoDTO);
}
