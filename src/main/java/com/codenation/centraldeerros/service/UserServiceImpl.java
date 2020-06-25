package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.entity.Usuario;
import com.codenation.centraldeerros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<Usuario> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<Usuario> save(Usuario usuario) {
        return Optional.ofNullable(userRepository.save(usuario));
    }

    public Usuario findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email);
    }
}

