package com.codenation.centraldeerros.repository;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import com.google.gson.JsonElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    Page<Evento> findAll(Pageable pageable);

    Evento save(Evento evento);

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByOrigem(String origem, Pageable pageable);

    Page<Evento> findByData(LocalDateTime data, Pageable pageable);

    @Query(" select e.log from Evento e " +
            " where e.id = :id ")
    Optional<String> findByIdLog(Long id);
}
