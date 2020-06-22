package com.codenation.centraldeerros.controller;

import com.codenation.centraldeerros.entity.User;
import com.codenation.centraldeerros.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class UserController {

    private UserService service;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

}
