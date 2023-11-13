package com.example.todoservice.service;

import com.example.todoservice.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
    private List<Tarefa> listaTarefas = new ArrayList<>();

    public List<Tarefa> listarTarefas() {
        return listaTarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public String editarTarefa(int idTarefa, Tarefa tarefaAtualizada) {
        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa tarefa = listaTarefas.get(i);
            if (tarefa.getId() == idTarefa) {
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setDataVencimento(tarefaAtualizada.getDataVencimento());
                tarefa.setEstado(tarefaAtualizada.isEstado());

                return "Tarefa editada.";
            }
        }

        return "Tarefa com o ID " + idTarefa + " não encontrada.";
    }

    public String removerTarefa(int idTarefa) {
        for (int i = 0; i < listaTarefas.size(); i++) {
            Tarefa tarefa = listaTarefas.get(i);
            if (tarefa.getId() == idTarefa) {
                listaTarefas.remove(i);
                return "Tarefa removida.";
            }
        }

        return "Tarefa com o ID " + idTarefa + " não encontrada.";
    }
}
