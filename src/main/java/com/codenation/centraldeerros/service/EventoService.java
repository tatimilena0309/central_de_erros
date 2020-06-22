package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.entity.Evento;
import org.springframework.data.domain.Pageable;
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

    List<Evento> findByOrigem(String origem, Pageable pageable);

    List<Evento> findByData(LocalDateTime data, Pageable pageable);
}
