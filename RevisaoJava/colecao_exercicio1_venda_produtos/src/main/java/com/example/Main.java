package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GerenciamentoVendas gv = new GerenciamentoVendas();
        String operacao;
        do{
            operacao = JOptionPane.showInputDialog(
                "\n---Gerenciamento de Vendas---\n"
                +"1 - Registrar Vendas \n"
                +"2 - Listar Vendas do Cliente \n"
                +"3 - Listar Vendas Valor Mínimo \n"
                +"4 - Sair");
                switch (operacao) {
                    case "1":
                        String cpf = JOptionPane.showInputDialog(
                            "Informe o CPF do Cliente");
                        String nomeProduto = JOptionPane.showInputDialog(
                            "Informe o nome do Produto");
                        double valorProduto = Double.parseDouble(JOptionPane.showInputDialog(
                            "Informe o valor do Produto"));
                        Produto produto = new Produto(nomeProduto, valorProduto);
                        gv.venda(cpf, produto);
                        break;
                    case "2":
                        String cpf2 = JOptionPane.showInputDialog(
                            "informe o CPF do cliente");
                        gv.produtosClientes(cpf2);
                        break;
                    case "3":
                        String cpf3 = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                        double valorMinimoProduto = Double.parseDouble(JOptionPane.showInputDialog(
                            "Informe o valor minimo do Produto"));
                        gv.produtosClientesAcimaDe(cpf3, valorMinimoProduto);
                        break;
                    case "4":
                    System.out.println("Sair");
                    default:
                        break;
                }
        }while(operacao!="4");

    }
}