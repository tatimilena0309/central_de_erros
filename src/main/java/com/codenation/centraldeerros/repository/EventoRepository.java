package com.codenation.centraldeerros.repository;

import com.codenation.centraldeerros.enums.Level;
import com.codenation.centraldeerros.entity.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

//public interface EventoRepository extends CrudRepository<Evento, Long> {
@Repository
public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);

    Evento save(Evento evento);

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByOrigem(String origem, Pageable pageable);

    Page<Evento> findByData(LocalDateTime data, Pageable pageable);

    @Query(" select e.log from Evento e " +
            " where e.id = :id ")
    Optional<String> findByIdLog(Long id);

    //FUNCTION get_text (p_param IN VARCHAR2) RETURN VARCHAR2
   /* @Autowired
    JdbcTemplate jdbcTemplate;

    public String callGetTextFunction(String param) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_PACKAGE") //package name
                .withFunctionName("GET_TEXT"); //function name
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_param", param));
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(String.class, paramMap));
    }*/

}

