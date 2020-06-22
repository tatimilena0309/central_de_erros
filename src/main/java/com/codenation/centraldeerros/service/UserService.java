package com.codenation.centraldeerros.service;

import com.codenation.centraldeerros.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long userId);
}
