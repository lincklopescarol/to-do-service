package com.example.todoservice;
import static org.junit.jupiter.api.Assertions.*;
import com.example.todoservice.service.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

public class TarefaServiceTest {
    private TarefaService tarefaService;

    // esse before inicializa uma nova tarefa toda vez de teste, para não ter que criar várias
    @BeforeEach
    public void inicializaTarefa() {
        tarefaService = new TarefaService();
    }

    @Test
    public void testListarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        assertNotNull(tarefas); // verifica se a tarefa não é nula
        assertEquals(0, tarefas.size()); // verifica o tamanho da lista que deve ser 0, se não tem nada adicionado
    }

    @Test
    public void testAdicionarTarefa() {
        Tarefa tarefa = new Tarefa(1, "Descrição", LocalDateTime.now());
        tarefaService.adicionarTarefa(tarefa);
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        assertEquals(1, tarefas.size());
    }

    @Test
    public void testEditarTarefa() {
        Tarefa tarefa = new Tarefa(1, "Descrição", LocalDateTime.now());
        tarefaService.adicionarTarefa(tarefa);

        Tarefa tarefaAtualizada = new Tarefa(1, "Descrição atualizada", LocalDateTime.now());
        String resultado = tarefaService.editarTarefa(1, tarefaAtualizada);
        assertEquals("Tarefa editada.", resultado);

        List<Tarefa> tarefas = tarefaService.listarTarefas();
        assertEquals("Descrição atualizada", tarefas.get(0).getDescricao()); // tem o get 0 pra acessar o primeiro elemento da lista
    }

    @Test
    public void testRemoverTarefa() {
        Tarefa tarefa = new Tarefa(1, "Descrição", LocalDateTime.now());
        tarefaService.adicionarTarefa(tarefa);

        String resultado = tarefaService.removerTarefa(1);
        assertEquals("Tarefa removida.", resultado);

        List<Tarefa> tarefas = tarefaService.listarTarefas();
        assertEquals(0, tarefas.size());
    }
}
