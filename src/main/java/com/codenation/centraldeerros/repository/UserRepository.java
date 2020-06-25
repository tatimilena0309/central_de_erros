package com.codenation.centraldeerros.repository;

import com.codenation.centraldeerros.entity.Evento;
import com.codenation.centraldeerros.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario save(Usuario usuario);
}
