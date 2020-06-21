package com.codenation.centraldeerros.dto;

import com.codenation.centraldeerros.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResponseEventoDTO {

    private Long id;
    private Level level;
    private String descricao;
    private String origem;
    private String data;
    private Integer quantidade;

    public ResponseEventoDTO(Long id, Level level, String descricao, String origem, String data, Integer quantidade) {
        this.id = id;
        this.level = level;
        this.descricao= descricao;
        this.origem = origem;
        this.data = data;
        this.quantidade = quantidade;
    }

    public ResponseEventoDTO() {
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

