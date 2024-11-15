package com.kanban.view;

import com.kanban.controller.KanbanController;
import com.kanban.model.Tarefa;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskRegistrationView {
    private final KanbanController controller = new KanbanController();

    public void showRegistrationForm() {
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Tarefa");

        // Definir os campos de entrada
        TextField descricaoField = new TextField();
        descricaoField.setPromptText("Descrição da tarefa");

        TextField setorField = new TextField();
        setorField.setPromptText("Setor");

        ComboBox<String> prioridadeComboBox = new ComboBox<>();
        prioridadeComboBox.getItems().addAll("Baixa", "Média", "Alta");
        prioridadeComboBox.setPromptText("Prioridade");

        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("a fazer", "fazendo", "pronto");
        statusComboBox.setPromptText("Status");

        // Botões de ação
        Button saveButton = new Button("Salvar");
        saveButton.setOnAction(event -> {
            // Coleta os dados
            String descricao = descricaoField.getText();
            String setor = setorField.getText();
            String prioridade = prioridadeComboBox.getValue();
            String status = statusComboBox.getValue();

            // Validação de campos
            if (descricao.isEmpty() || setor.isEmpty() || prioridade == null || status == null) {
                showError("Todos os campos devem ser preenchidos!");
                return;
            }

            // Cria a tarefa
            Tarefa tarefa = new Tarefa();
            tarefa.setDescricao(descricao);
            tarefa.setSetor(setor);
            tarefa.setPrioridade(prioridade);
            tarefa.setStatus(status);

            // Chama o controlador para salvar a tarefa
            controller.addTarefa(tarefa);

            // Fecha a janela de cadastro
            stage.close();

            // Aqui você pode adicionar algum código para atualizar a interface, por exemplo,
            // atualizar as tabelas do Kanban, caso necessário.
        });

        Button cancelButton = new Button("Cancelar");
        cancelButton.setOnAction(event -> stage.close());

        // Layout
        VBox layout = new VBox(10, descricaoField, setorField, prioridadeComboBox, statusComboBox, saveButton, cancelButton);
        layout.setPrefWidth(300);

        // Criação da cena e exibição
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
