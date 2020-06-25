package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {

    Optional<Usuario> findById(Long userId);

    Optional<Usuario> save(Usuario usuario);

    Usuario findByEmail(String email);
}
