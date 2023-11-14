package com.example.todoservice.controller;

import com.example.todoservice.Tarefa;
import com.example.todoservice.service.TarefaService; // Importe a classe de serviço.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        if (!tarefas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(tarefas);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tarefas);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarTarefa(@RequestBody Tarefa tarefa) {
        try {
            tarefaService.adicionarTarefa(tarefa);
            return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa adicionada.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar a tarefa: " + ex.getMessage());
        }
    }

    @PutMapping("/editar/{idTarefa}")
    public ResponseEntity<String> editarTarefa(@PathVariable int idTarefa, @RequestBody Tarefa tarefaAtualizada) {
        String resultado = tarefaService.editarTarefa(idTarefa, tarefaAtualizada);

        if (resultado.equals("Tarefa editada.")) {
            return ResponseEntity.status(HttpStatus.OK).body("Tarefa editada.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
    }

    @DeleteMapping("/remover/{idTarefa}")
    public ResponseEntity<String> removerTarefa(@PathVariable int idTarefa) {
        String resultado = tarefaService.removerTarefa(idTarefa);

        if (resultado.equals("Tarefa removida.")) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada.");
        }
    }
}
