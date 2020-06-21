package com.codenation.centraldeerros.dto;

import com.codenation.centraldeerros.enums.Level;

public class InsertEventoDTO {
    private Level level;
    private String descricao;
    private String log;
    private String origem;
    private String data;

    public InsertEventoDTO() {
    }

    public InsertEventoDTO(Level level, String descricao, String log, String origem, String data) {
        this.level = level;
        this.descricao = descricao;
        this.log = log;
        this.origem = origem;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
