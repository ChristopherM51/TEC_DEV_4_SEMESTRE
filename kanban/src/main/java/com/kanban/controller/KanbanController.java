package com.kanban.controller;

import com.kanban.model.Tarefa;
import com.kanban.repository.TarefaRepository;

import java.util.List;

public class KanbanController {
    private final TarefaRepository tarefaRepository = new TarefaRepository();

    // Obtém todas as tarefas
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    // Adiciona uma nova tarefa
    public void addTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    // Atualiza o status de uma tarefa
    public void updateTarefa(Tarefa tarefa) {
        tarefaRepository.update(tarefa);
    }

    // Remove uma tarefa pelo ID
    public void deleteTarefa(int id) {
        tarefaRepository.deleteById(id);
    }
}
