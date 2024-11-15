package com.kanban.view;

import com.kanban.controller.UserController;
import com.kanban.model.Usuario;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserRegistrationView {

    private final UserController userController = new UserController();

    public void start(Stage primaryStage) {
        // Campos para cadastro de usuário
        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Button saveButton = new Button("Salvar");
        saveButton.setOnAction(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();

            // Validação simples dos campos
            if (!nome.isEmpty() && !email.isEmpty()) {
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setEmail(email);
                userController.addUsuario(usuario);
                nomeField.clear();
                emailField.clear();
            } else {
                System.out.println("Todos os campos são obrigatórios.");
            }
        });

        VBox vbox = new VBox(10, new Label("Cadastro de Usuário"), nomeField, emailField, saveButton);
        vbox.setPadding(new Insets(15));
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Cadastro de Usuários");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
