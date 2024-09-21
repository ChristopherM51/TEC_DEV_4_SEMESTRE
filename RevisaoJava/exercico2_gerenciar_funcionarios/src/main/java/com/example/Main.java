package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int oprecao = 0;
        do {
            oprecao = Integer.parseInt(JOptionPane.showInputDialog(
                "\n---Gerenciamento de Funcionarios---\n"
                        + "1- Adicionar funcionario\n"
                        + "2- Listar funcionario\n"
                        + "3- Buscar Funcionario\n"
                        + "4- Média Salarial Funcionario\n"
                        + "5- Remover Funcionario\n"
                        + "6- Sair...\n"));
                        switch (oprecao) {
                            case 1:
                                gerenciaFuncionario.addFuncionario();
                                break;
                            case 2:
                                gerenciaFuncionario.listarFuncionarios();
                            break;
                            case 3:
                                gerenciaFuncionario.buscarFuncionario();
                            break;
                            case 4:
                                gerenciaFuncionario.calculoMediaSalario();
                            break;
                            case 5:
                                gerenciaFuncionario.removerFuncionario();
                            break;
                            case 6:
                                System.out.println("Saindo...");
                            break;
                            default:
                                break;
                        }
        } while (oprecao !=5 );
        
    }
}