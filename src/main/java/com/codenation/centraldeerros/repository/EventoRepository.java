package com.codenation.centraldeerros.repository;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    Page<Evento> findAll(Pageable pageable);

    Evento save(Evento evento);

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findById(Long id, Pageable pageable);
}
