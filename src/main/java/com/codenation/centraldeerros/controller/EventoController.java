package com.codenation.centraldeerros.controller;


import com.codenation.centraldeerros.model.Evento;
import com.codenation.centraldeerros.service.EventoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        return new ResponseEntity<Evento>(this.eventoService.save(evento), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Evento> findAll(Pageable pageable) {
        return this.eventoService.findAll(pageable);
    }
}


