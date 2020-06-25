package com.codenation.centraldeerros.endpoint.controller;

import com.codenation.centraldeerros.entity.Usuario;
import com.codenation.centraldeerros.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService service;

   // @Autowired
    //private ImplementsUserDetailService implementsUserDetailService;

    @GetMapping("/usuario/cadastrar")
    public ModelAndView newUserPag() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastro");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }
    @PostMapping("/usuario/save")
    public String create(@Valid @ModelAttribute Usuario usuario) {
        Optional<Usuario> save = service.save(usuario);
        if (!save.isPresent()) {
            return "redirect:cadastro";
        }
        return "redirect:login";
    }

    @GetMapping("/usuario/login")
    public ModelAndView newLoginPag() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("usuario", new Usuario() {
        });
        return modelAndView;
    }

    @PostMapping("/usuario/autenticar")
    public String autenticar(@Valid @ModelAttribute Usuario usuario) {
       /* UserDetails userDetails = this.implementsUserDetailService.loadUserByUsername(usuario.getEmail());
        if (userDetails == null) {
            return "redirect:/login";
        }
        if (userDetails.getUsername().equals(usuario.getEmail()) && userDetails.getPassword().equals(usuario.getPassword())) {
            return "redirect:/evento";
        }
        return "redirect:/login";
    }*/
    return null;}

}
