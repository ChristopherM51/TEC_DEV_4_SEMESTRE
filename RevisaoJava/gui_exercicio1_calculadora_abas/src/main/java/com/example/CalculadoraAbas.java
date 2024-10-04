package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CalculadoraAbas extends JFrame {
    // Atributos
    //
    // Construtor
    public CalculadoraAbas() {
        super("Calculadora Abas");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        //
        // Adicionar os componetes
        JTabbedPane abas = new JTabbedPane();
        //
        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("Simples", calcSimples);
        //
        JPanel calcAvancada = new CalculadoraAvancada();
        abas.addTab("Avançada", calcAvancada);
        //
        this.add(abas);
        this.setVisible(true);
    }
}
