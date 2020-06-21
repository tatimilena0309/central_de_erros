package com.codenation.centraldeerros.controller;


import com.codenation.centraldeerros.dto.ResponseEventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.entity.Evento;
import com.codenation.centraldeerros.mappers.EventoResponseMapper;
import com.codenation.centraldeerros.service.EventoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoResponseMapper eventoMapper;
    //public static EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    @PostMapping
    public ResponseEntity<ResponseEventoDTO> create(@RequestBody Evento evento) {
        //Evento eventoMap = eventoMapper.map();
        return new ResponseEntity<ResponseEventoDTO>(this.eventoMapper.map(this.eventoService.save(evento)), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ResponseEventoDTO> findAll(Pageable pageable) {
        return eventoMapper.map(this.eventoService.findAll(pageable));
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


