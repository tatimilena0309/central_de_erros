package com.codenation.centraldeerros.controller;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.model.Evento;
import com.codenation.centraldeerros.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    public ResponseEntity<String> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<String>(this.eventoService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/byLevel/{level}")
    // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>> findByLevel(@PathVariable("level") Level level, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findByLevel(level, pageable), HttpStatus.OK);
    }

    @GetMapping("/byDescricao/{descricao}")
    // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>> findByDescricao(@PathVariable("descricao") String descricao, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findByDescricao(descricao, pageable), HttpStatus.OK);
    }

    @GetMapping("/byOrigem/{origem}")
    // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>> findByOrigem(@PathVariable("origem") String origem, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findByOrigem(origem, pageable), HttpStatus.OK);
    }

    @GetMapping("/byData/{data}")
    // @ApiResponses(value = {@ApiResponse(code = 404, message = "Livro não localizado"), @ApiResponse(code = 200, message = "Livro localizado")})
    public ResponseEntity<Iterable<Evento>> findByData(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data, Pageable pageable) {
        return new ResponseEntity<Iterable<Evento>>(this.eventoService.findByData(data, pageable), HttpStatus.OK);
    }
}


