package com.codenation.centraldeerros.endpoint;

import com.codenation.centraldeerros.advice.ResourceNotFoundException;
import com.codenation.centraldeerros.dto.InsertEventoDTO;
import com.codenation.centraldeerros.dto.ResponseEventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.mappers.EventoInsertMapper;
import com.codenation.centraldeerros.mappers.EventoResponseMapper;
import com.codenation.centraldeerros.service.EventoService;
import io.swagger.annotations.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/evento")
public class EventoResource {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoResponseMapper eventoResponseMapper;

    @Autowired
    private EventoInsertMapper eventoInsertMapper;


    @ApiOperation(value = "Cria um novo Evento", response = ResponseEventoDTO[].class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Evento adicionado")})
    @PostMapping
    public ResponseEntity<ResponseEventoDTO> create(@RequestBody InsertEventoDTO evento) {
        return new ResponseEntity<ResponseEventoDTO>(this.eventoResponseMapper
                .map(this.eventoService.save(this.eventoInsertMapper.map(evento))), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna a lista com todos os eventos cadastrados", response = ResponseEventoDTO[].class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso")})
    @GetMapping
    public ResponseEntity<List<ResponseEventoDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(eventoResponseMapper.map(this.eventoService.findAll(pageable)), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna o LOG de um evento", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Evento não localizado"), @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado!")), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna lista buscando pelo Level", response = ResponseEventoDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foram encontrados Registros"), @ApiResponse(code = 200, message = "Ok")})
    @GetMapping("/byLevel/{level}")
    public ResponseEntity<Iterable<ResponseEventoDTO>> findByLevel(@PathVariable("level") Level level, Pageable pageable) {
        return new ResponseEntity<>(this.eventoResponseMapper.map(this.eventoService.findByLevel(level, pageable)), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna lista buscando pela descrição", response = ResponseEventoDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foram encontrados Registros"), @ApiResponse(code = 200, message = "Ok")})
    @GetMapping("/byDescricao/{descricao}")
    public ResponseEntity<Iterable<ResponseEventoDTO>> findByDescricao(@PathVariable("descricao") String descricao, Pageable pageable) {
        return new ResponseEntity<>(this.eventoResponseMapper.map(this.eventoService.findByDescricao(descricao, pageable)), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna lista buscando pela Origem", response = ResponseEventoDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foram encontrados Registros"), @ApiResponse(code = 200, message = "Ok")})
    @GetMapping("/byOrigem/{origem}")
    public ResponseEntity<Iterable<ResponseEventoDTO>> findByOrigem(@PathVariable("origem") String origem, Pageable pageable) {
        return new ResponseEntity<>(this.eventoResponseMapper.map(this.eventoService.findByOrigem(origem, pageable)), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna lista buscando pela Data", response = ResponseEventoDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foram encontrados registros para esta Data"), @ApiResponse(code = 200, message = "Ok")})
    @GetMapping("/byData/{data}")
    public ResponseEntity<Iterable<ResponseEventoDTO>> findByData(@PathVariable("data") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data, Pageable pageable) {
        return new ResponseEntity<>(this.eventoResponseMapper.map(this.eventoService.findByData(data, pageable)), HttpStatus.OK);
    }
    @ApiOperation(value = "Retorna lista buscando pela quantidade", response = ResponseEventoDTO.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Não foram encontrados registros"), @ApiResponse(code = 200, message = "Ok")})
    @GetMapping("/byQuantidade/{quantidade}")
    public ResponseEntity<Iterable<ResponseEventoDTO>> findByQuantidade(@PathVariable("quantidade")Integer quantidade, Pageable pageable) {
        return new ResponseEntity<>(this.eventoResponseMapper.map(this.eventoService.findByQuantidade(quantidade, pageable)), HttpStatus.OK);
    }
}
