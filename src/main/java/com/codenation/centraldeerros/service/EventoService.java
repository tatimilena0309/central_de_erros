package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.dto.EventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import com.google.gson.JsonElement;
import org.springframework.data.convert.ThreeTenBackPortConverters;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll(Pageable pageable);

    Optional<String> findById(Long id);

    Evento save(Evento evento);

    void deleteById(Long id);

    List<Evento> findByLevel(Level level, Pageable pageable);

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    List<Evento>  findByOrigem(String origem, Pageable pageable);

    List<Evento> findByData(LocalDateTime data, Pageable pageable);
}
