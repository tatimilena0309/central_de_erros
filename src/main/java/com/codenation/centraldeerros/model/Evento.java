package com.codenation.centraldeerros.model;

import com.codenation.centraldeerros.enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Table(name = "evento")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    private Level level;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @NotBlank
    private String  log;

    @NotNull
    @NotBlank
    private String origem;

    @NotNull
    @NotBlank

    // @JsonFormat(pattern = "yyyy-MM-dd")
   // private LocalDate localDate;
    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    //    private Date date;
    //
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//
    private LocalDateTime data;

    @NotNull
    @NotBlank
    private Integer quantidade;

    public Evento() {
    }

    public Evento(Long id, @NotNull @NotBlank Level level, @NotNull @NotBlank String descricao, @NotNull @NotBlank String log, @NotNull @NotBlank String origem, @NotNull @NotBlank LocalDateTime data, @NotNull @NotBlank Integer quantidade) {
        this.id = id;
        this.level = level;
        this.descricao = descricao;
        this.log = log;
        this.origem = origem;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
