package com.example;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraAvancada extends JPanel {
    JTextField displayAvancada;
    String[] botoes = {
            "7", "8", "9", "/","!",
            "4", "5", "6", "*","sqrt",
            "1", "2", "3", "-","log",
            "0", ".", "+", "^","="
    };

    //
    // Construtor
    public CalculadoraAvancada() {
        super(new BorderLayout());
        displayAvancada = new JTextField();
        displayAvancada.setHorizontalAlignment(JTextField.RIGHT);
        displayAvancada.setEditable(false);
        this.add(displayAvancada, BorderLayout.NORTH);
        //
        // Criar um Painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(4, 5, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            //Adicionar ação aos botões
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }
}
