package com.example.todoservice.controller;

import com.example.todoservice.Tarefa;
import com.example.todoservice.service.TarefaService; // Importe a classe de serviço.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        // chamando o serviço para listar as tarefas.
        return tarefaService.listarTarefas();
    }

    @PostMapping("/adicionar")
    public void adicionarTarefa(@RequestBody Tarefa tarefa) {
        // chamando o serviço para adicionar a tarefa.
        tarefaService.adicionarTarefa(tarefa);
    }

    @PutMapping("/editar/{idTarefa}")
    public String editarTarefa(@PathVariable int idTarefa, @RequestBody Tarefa tarefaAtualizada) {
        // chamando o serviço para editar a tarefa.
        String resultado = tarefaService.editarTarefa(idTarefa, tarefaAtualizada);

        if (resultado.equals("Tarefa editada.")) {
            return resultado;
        } else {
            return "Tarefa não encontrada.";
        }
    }

    @DeleteMapping("/remover/{idTarefa}")
    public String removerTarefa(@PathVariable int idTarefa) {
        // chamando o serviço para remover a tarefa.
        String resultado = tarefaService.removerTarefa(idTarefa);

        if (resultado.equals("Tarefa removida.")) {
            return resultado;
        } else {
            return "Tarefa não encontrada.";
        }
    }
}
