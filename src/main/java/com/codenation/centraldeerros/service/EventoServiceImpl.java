package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.entity.Evento;
import com.codenation.centraldeerros.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll(Pageable pageable) {
        return  this.eventoRepository.findAll(pageable).getContent();
    }

    @Override
    public Evento save(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Evento> findByLevel(Level level, Pageable pageable) {

        return this.eventoRepository.findByLevel(level, pageable).getContent();
    }

    @Override
    public List<Evento> findByDescricao(String descricao, Pageable pageable) {
        return this.eventoRepository.findByDescricao(descricao, pageable).getContent();
    }

    @Override
    public List<Evento> findByOrigem(String origem, Pageable pageable) {
        return this.eventoRepository.findByOrigem(origem, pageable).getContent();
    }

    @Override
    public List<Evento> findByData(LocalDateTime data, Pageable pageable) {
        return this.eventoRepository.findByData(data, pageable).getContent();
    }

    @Override
    public Optional<String> findById(Long id) {
        return Optional.of(this.eventoRepository.findByIdLog(id).get());
    }
}
