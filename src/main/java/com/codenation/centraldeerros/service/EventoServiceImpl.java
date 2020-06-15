package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.model.Evento;
import com.codenation.centraldeerros.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll(Pageable pageable) {
        return this.eventoRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Evento save(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Evento> findByLevel(String level, Pageable pageable) {
        return null;
    }
}
