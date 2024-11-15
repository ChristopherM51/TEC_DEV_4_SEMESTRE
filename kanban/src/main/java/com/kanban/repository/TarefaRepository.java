package com.kanban.repository;

import com.kanban.model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> findAll() {
        return new ArrayList<>(tarefas);
    }

    public void save(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void update(Tarefa tarefa) {
        // Simples atualização (ajustar conforme lógica de banco, se houver)
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == tarefa.getId()) {
                tarefas.set(i, tarefa);
                break;
            }
        }
    }

    public void deleteById(int id) {
        tarefas.removeIf(t -> t.getId() == id);
    }
}
