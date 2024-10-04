package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinhaJanela extends JFrame {
    public MinhaJanela() {
        super("Minha Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
        //
        //Criando um painel(Container generico)
        JPanel painel = new JPanel();
        this.add(painel);
        //
        //Adicionando um Botão
        JButton botao = new JButton("Clique aqui");
        painel.add(botao);
        //
        //Adicionar um evento no botão
        // botao.addActionListener(new ActionListener(){
        //     @Override
        //     public void actionPerformed(ActionEvent e){
        //         JOptionPane.showMessageDialog(null,"Botão Clicado");
        //     }
        // });
        botao.addActionListener(e->{
            JOptionPane.showMessageDialog(null,
                "Botão01 Clicado"
            );
        });
        
    }
}
