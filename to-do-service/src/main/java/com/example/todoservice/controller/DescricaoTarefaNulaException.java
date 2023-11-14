package com.example.todoservice.controller;
// classe criada para dar uma mensagem na exceção
public class DescricaoTarefaNulaException extends RuntimeException {
    public DescricaoTarefaNulaException(String mensagem) {
        super(mensagem);
    }
}
