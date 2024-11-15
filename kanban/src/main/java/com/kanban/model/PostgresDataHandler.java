package com.kanban.model;

import com.kanban.model.Tarefa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresDataHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static List<Tarefa> readTarefas() throws SQLException {
        List<Tarefa> tarefas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tarefas")) {

            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getString("descricao"),
                    rs.getString("setor"),
                    rs.getString("prioridade"),
                    rs.getTimestamp("data_cadastro").toString(),
                    rs.getString("status")
                );
                tarefas.add(tarefa);
            }
        }
        return tarefas;
    }

    // Outros métodos de CRUD, como inserir, atualizar e excluir, precisam ser implementados de forma semelhante.
}
