package com.codenation.centraldeerros.controller;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import com.codenation.centraldeerros.service.EventoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

   // @Autowired
    //private EventoMapper eventoMapper;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
        //this.eventoMapper = eventoMapper;
    }

    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        //Evento eventoMap = eventoMapper.map();
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }
    @GetMapping
    public Iterable<Evento> findAll(Pageable pageable) {
        return this.eventoService.findAll(pageable);
    }
    @GetMapping("/{id}")
   // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>>findById(@PathVariable("id") Long id, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findById(id,pageable), HttpStatus.OK);
    }
    @GetMapping("/byLevel/{level}")
    // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>>findByLevel(@PathVariable("level") Level level, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findByLevel(level,pageable), HttpStatus.OK);
    }
}


