package com.codenation.centraldeerros.controller;

import com.codenation.centraldeerros.dto.InsertEventoDTO;
import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.mappers.EventoInsertMapper;
import com.codenation.centraldeerros.mappers.EventoResponseMapper;
import com.codenation.centraldeerros.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoResponseMapper eventoResponseMapper;

    @Autowired
    private EventoInsertMapper eventoInsertMapper;

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute InsertEventoDTO evento, BindingResult result, RedirectAttributes
            redirectAttributes) {
        if (result.hasErrors()) {
            return "new-evento";
        }
        this.eventoResponseMapper.map(this.eventoService.save(this.eventoInsertMapper.map(evento)));
        redirectAttributes.addFlashAttribute("message", "Evento cadastrado com sucesso.");
        return "redirect:";
    }

    @GetMapping
    public ModelAndView findAll(Pageable pageable) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", eventoResponseMapper.map(this.eventoService.findAll(pageable)));
        return modelAndView;
    }

    @GetMapping("/new-evento")
    public ModelAndView newEventoPag() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-evento");
        modelAndView.addObject("evento", new InsertEventoDTO());
        return modelAndView;
    }

    @GetMapping("/byId/{id}")
    public ModelAndView findById(@PathVariable("id") final Long id, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {

        //final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("resposta", this.eventoService.findById(id).get());
        return modelAndView;
        //return "redirect:/evento";
    }

    @GetMapping("/byLevel")
    public ModelAndView findByLevel(@RequestParam(value = "level") Level level, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByLevel(level, pageable)));
        return modelAndView;
    }

    @GetMapping("/byDescricao")
    public ModelAndView findByDescricao(@RequestParam(value = "descricao") String descricao, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByDescricao(descricao, pageable)));
        return modelAndView;
    }

    @GetMapping("/byOrigem")
    public ModelAndView findByOrigem(@RequestParam(value = "origem") String origem, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByOrigem(origem, pageable)));
        return modelAndView;
    }

    @GetMapping("/byData")
    public ModelAndView findByData(@RequestParam(value = "data") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data, Model model, Pageable pageable, RedirectAttributes redirectAttributes) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("evento");
        modelAndView.addObject("allEventos", this.eventoResponseMapper.map(this.eventoService.findByData(data, pageable)));
        return modelAndView;
    }

}


