package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController(){
        funcionarios = new ArrayList<>();
    }
    //Método add Funcionario
    public void addFuncionario(){
        //Criar o Funcionário
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o Salario"));
        //
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionario.add(funcionario);
    }
    //Método para listar Funcionarios
    public void listarFuncionarios(){
        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario.toString());
        }
    }
    //Buscar funcionario pelo nome
    public void buscarFuncionario(){
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario a ser buscado");
    try{
        boolean encontrado = false;
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equalsIgnoreCase(nome)){
                System.out.println(funcionario.toString());
                encontrado=true;
            }
        }
        if(!encontrado){
            throw new Exception("Funcionário não Encontrado");
        }
    }catch(Exception e){
        System.err.println(e);
    }
    }
    //Remover funcionario
    public void removerFuncionario(){
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario a ser removido");
    try{
        boolean encontrado = false;
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getNome().equalsIgnoreCase(nome)){
                funcionarios.remove(funcionario);
                encontrado=true;
                System.out.println("Funcionario removido");
                break;
            }
        }
        if(!encontrado){
            throw new Exception("Funcionário não Encontrado");
        }
    }catch(Exception e){
        System.err.println(e);
    }
    }
    //Calculo de média salarial
    public void calculoMediaSalario(){
        double mediaSalario = 0;
        if (funcionarios.size() == 0){
            System.out.println("Nenhum funcionario cadastrado");
        }else{
            for(Funcionario funcionario :funcionarios){
            mediaSalario += funcionario.getSalario();
        }
        mediaSalario/=funcionarios.size();
        System.out.println("A media de Salários é "+mediaSalario);
    }
}
}
