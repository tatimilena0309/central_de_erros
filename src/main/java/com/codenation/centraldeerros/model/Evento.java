package com.codenation.centraldeerros.model;

import com.codenation.centraldeerros.enums.Level;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

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
    private String descricaoEvento;

    @NotNull
    @NotBlank
    private String logEvento;

    @NotNull
    @NotBlank
    private String origem;

    @NotNull
    @NotBlank
    private Timestamp data;

    @NotNull
    @NotBlank
    private Integer quantidade;

    public Evento() {
    }

    public Evento(Long id, Level level, String descricaoEvento, String logEvento, String origem, Timestamp data, Integer quantidade) {
        this.id = id;
        this.level = level;
        this.descricaoEvento = descricaoEvento;
        this.logEvento = logEvento;
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

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getLogEvento() {
        return logEvento;
    }

    public void setLogEvento(String logEvento) {
        this.logEvento = logEvento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
