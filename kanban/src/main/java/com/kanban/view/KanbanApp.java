package com.kanban.view;

import com.kanban.controller.KanbanController;
import com.kanban.model.Tarefa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class KanbanApp extends Application {
    private TableView<Tarefa> tarefasAFazer;
    private TableView<Tarefa> tarefasFazendo;
    private TableView<Tarefa> tarefasProntas;

    private final KanbanController controller = new KanbanController();

    @Override
    public void start(Stage primaryStage) {
        // Obtém todas as tarefas
        List<Tarefa> tarefas = controller.getAllTarefas();
        
        // Criação das tabelas
        tarefasAFazer = createTarefaTable("a fazer", tarefas);
        tarefasFazendo = createTarefaTable("fazendo", tarefas);
        tarefasProntas = createTarefaTable("pronto", tarefas);

        // Organizando as tabelas em HBox
        HBox root = new HBox(10, tarefasAFazer, tarefasFazendo, tarefasProntas);
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("Kanban de Tarefas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Tarefa> createTarefaTable(String status, List<Tarefa> tarefas) {
        TableView<Tarefa> table = new TableView<>();
        
        // Filtra tarefas por status
        ObservableList<Tarefa> tarefasStatus = FXCollections.observableArrayList(
            tarefas.stream().filter(t -> t.getStatus().equals(status)).toList()
        );
        table.setItems(tarefasStatus);
        
        // Criação das colunas da tabela
        TableColumn<Tarefa, String> descricaoColumn = new TableColumn<>("Descrição");
        descricaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        TableColumn<Tarefa, String> setorColumn = new TableColumn<>("Setor");
        setorColumn.setCellValueFactory(new PropertyValueFactory<>("setor"));
        
        TableColumn<Tarefa, String> prioridadeColumn = new TableColumn<>("Prioridade");
        prioridadeColumn.setCellValueFactory(new PropertyValueFactory<>("prioridade"));
        
        TableColumn<Tarefa, Void> actionColumn = new TableColumn<>("Ações");
        actionColumn.setCellFactory(col -> new TableCell<Tarefa, Void>() {
            private final Button btnDelete = new Button("Excluir");
            private final Button btnUpdate = new Button("Atualizar");

            {
                // Ação para excluir a tarefa
                btnDelete.setOnAction(event -> {
                    Tarefa tarefa = getTableView().getItems().get(getIndex()); // Correção aqui
                    controller.deleteTarefa(tarefa.getId());
                    refreshTables();
                });

                // Ação para atualizar a tarefa
                btnUpdate.setOnAction(event -> {
                    Tarefa tarefa = getTableView().getItems().get(getIndex()); // Correção aqui
                    // Exemplo: mudando o status para "fazendo"
                    tarefa.setStatus("fazendo"); 
                    controller.updateTarefa(tarefa);
                    refreshTables();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox actionBox = new HBox(10, btnUpdate, btnDelete);
                    setGraphic(actionBox);
                }
            }
        });

        // Adiciona as colunas à tabela
        table.getColumns().addAll(descricaoColumn, setorColumn, prioridadeColumn, actionColumn);
        return table;
    }

    // Atualiza as três tabelas
    private void refreshTables() {
        List<Tarefa> tarefas = controller.getAllTarefas();
        tarefasAFazer.setItems(FXCollections.observableArrayList(
            tarefas.stream().filter(t -> t.getStatus().equals("a fazer")).toList()
        ));
        tarefasFazendo.setItems(FXCollections.observableArrayList(
            tarefas.stream().filter(t -> t.getStatus().equals("fazendo")).toList()
        ));
        tarefasProntas.setItems(FXCollections.observableArrayList(
            tarefas.stream().filter(t -> t.getStatus().equals("pronto")).toList()
        ));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
