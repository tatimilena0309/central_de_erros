package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.model.Evento;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoService {
    List<Evento> findAll(Pageable pageable);

    Optional<Evento> findById(Long id);

    Evento save(Evento evento);

    void deleteById(Long id);

    List<Evento> findByLevel(String level, Pageable pageable);
}
