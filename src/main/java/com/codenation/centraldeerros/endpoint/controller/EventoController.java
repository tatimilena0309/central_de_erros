package com.codenation.centraldeerros.endpoint.controller;

import com.codenation.centraldeerros.dto.InsertEventoDTO;
import com.codenation.centraldeerros.dto.ResponseEventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.mappers.EventoInsertMapper;
import com.codenation.centraldeerros.mappers.EventoResponseMapper;
import com.codenation.centraldeerros.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoResponseMapper eventoResponseMapper;

    @Autowired
    private EventoInsertMapper eventoInsertMapper;

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/evento/create")
    // @Transactional(rollbackOn = Exception.class)
    public String create(@Valid @ModelAttribute InsertEventoDTO evento, BindingResult result, RedirectAttributes
            redirectAttributes) {
        if (result.hasErrors()) {
            return "new-evento";
        }
        this.eventoResponseMapper.map(this.eventoService.save(this.eventoInsertMapper.map(evento)));
        redirectAttributes.addFlashAttribute("message", "Evento cadastrado com sucesso.");
        return "redirect:";
    }

    @GetMapping(path = "/evento")
    public ModelAndView findAll(Pageable pageable) {
        //@AuthenticationPrincipal UserDetails userDetails) {
        //System.out.println(userDetails);
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", eventoResponseMapper.map(this.eventoService.findAll(pageable)));
        return modelAndView;
    }

    @GetMapping(path = "/evento/new-evento")
    public ModelAndView newEventoPag() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-evento");
        modelAndView.addObject("evento", new InsertEventoDTO());
        return modelAndView;
    }

    @GetMapping(path = "/evento/byId/{id}")
    public ModelAndView findById(@PathVariable("id") final Long id, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        modelAndView.setViewName("evento");
        modelAndView.addObject("resposta", this.eventoService.findById(id));
        return modelAndView;
        //return "redirect:/evento";
    }

    @GetMapping(path = "/evento/byLevel")
    public ModelAndView findByLevel(@RequestParam(value = "level") Level level, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByLevel(level, pageable)));
        return modelAndView;
    }

    @GetMapping(path = "/evento/byDescricao")
    public ModelAndView findByDescricao(@RequestParam(value = "descricao") String descricao, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByDescricao(descricao, pageable)));
        return modelAndView;
    }

    @GetMapping(path = "/evento/byOrigem")
    public ModelAndView findByOrigem(@RequestParam(value = "origem") String origem, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByOrigem(origem, pageable)));
        modelAndView.addObject(pageable);
        return modelAndView;
    }

    @GetMapping(path = "/evento/byData")
    public ModelAndView findByData(@RequestParam(value = "data") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByData(data, pageable)));
        return modelAndView;
    }
    @GetMapping(path = "/evento/byQuantidade")
    public ModelAndView findByQuantidade(@RequestParam(value = "quantidade") Integer quantidade , Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByQuantidade(quantidade, pageable)));
        return modelAndView;
    }

}


