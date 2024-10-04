package com.example;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraSimples extends JPanel {
    JTextField displaySimples;
    String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "+", "="
    };

    //
    // Construtor
    public CalculadoraSimples() {
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);
        //
        // Criar um Painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            //Adicionar ação aos botões
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }
    //Altera valor do display
    public void setDisplaySimples(String texto) {
        this.displaySimples.setText(texto);
    }
    //Pega valor do display
    public String getDisplay() {
        return displaySimples.getText();
    }
}
