package com.codenation.centraldeerros.repository;

import com.codenation.centraldeerros.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, Long> {
    Page<Evento> findAll(Pageable pageable);

    //Evento save(Evento evento);
}
