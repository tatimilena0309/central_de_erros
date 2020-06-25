package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.entity.Usuario;

import java.util.Optional;

public interface UserService {

    Optional<Usuario> findById(Long userId);

    Usuario save(Usuario usuario);

    Usuario findByEmail(String email);
}
