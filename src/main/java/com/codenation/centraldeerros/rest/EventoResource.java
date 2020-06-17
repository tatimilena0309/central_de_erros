package com.codenation.centraldeerros.rest;

import com.codenation.centraldeerros.model.Evento;
import com.codenation.centraldeerros.repository.EventoRepository;
import com.codenation.centraldeerros.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
public class EventoResource {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public Iterable<Evento> findAll(Pageable pageable) {
        return this.eventoService.findAll(pageable);
    }

   /* @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Optional<Jedi> jedi = Optional.ofNullable(repository.findById(id));
        if (jedi.isPresent()) {
            return ResponseEntity.ok(jedi.get());
        } else {
            return ResponseEntity.notFound().build();
            //throw new JediNotFoundException();
        }
        // return repository.findById(id).get();//Pois é um optional pode ou n existir
    }*/

    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        //Evento eventoMap = eventoMapper.map();
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

}
