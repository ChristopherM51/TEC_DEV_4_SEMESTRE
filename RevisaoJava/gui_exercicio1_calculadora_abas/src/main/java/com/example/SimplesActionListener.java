package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SimplesActionListener implements ActionListener{
    private double valorAtual = 0;
    JPanel calcSimples = new CalculadoraSimples()

    @Override
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();

        if(comando.matches("\\d")){
            //Composição dos numeros
            calcSimples.setDisplay(calcSimples.getDisplay()+comando);
        }else if(comando.matches("[+\\-*/]")){
            //Seleção da operação
            valorAtual = Double.parseDouble(calcSimples.getDisplay());
            operador = comando;
            displaySimples.setText("");
        }else if(comando.matches("=")){

        }
    }
}
