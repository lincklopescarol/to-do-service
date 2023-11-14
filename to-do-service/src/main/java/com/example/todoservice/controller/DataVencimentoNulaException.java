package com.example.todoservice.controller;

// classe criada para dar uma mensagem na exceção
public class DataVencimentoNulaException extends RuntimeException {
    public DataVencimentoNulaException(String mensagem) {
        super(mensagem);
    }
}