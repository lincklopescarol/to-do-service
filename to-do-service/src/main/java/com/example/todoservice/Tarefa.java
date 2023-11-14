package com.example.todoservice;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class Tarefa {
    private int id;
    @NotNull
    private String descricao;
    @NotNull
    private LocalDateTime dataVencimento;
    @NotNull
    private boolean estado;

    public Tarefa(int id, String descricao, LocalDateTime dataVencimento) {
        this.id = id;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.estado = false;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    // coloquei um setDescricao para caso queira mudar a descricao da tarefa futuramente
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
