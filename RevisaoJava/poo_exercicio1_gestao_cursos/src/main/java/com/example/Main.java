package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        String operacao = "0";
        do {
            operacao = JOptionPane.showInputDialog(
                "\n---Gerenciamento de Curso---\n"
                +"1 - Criar Curso \n"
                +"2 - Adicionar Professor \n"
                +"3 - Adicionar Aluno \n"
                +"4 - Informações do Curso \n"
                +"5 - Atribuir Nota \n"
                +"6 - Resultado Final \n"
                +"7 - Sair"
            );
            switch (operacao) {
                case "1":
                    String nomeCurso = JOptionPane.showInputDialog("Informe o nome do Curso:");
                    cursos.add(new Curso(nomeCurso));
                    break;
                case "2":
                    String nomeCursoProfessor = JOptionPane.showInputDialog("Informe o nome do Professor:");
                    for (Curso curso : cursos) {
                        if(curso.getNomeCurso().equalsIgnoreCase(nomeCursoProfessor)){
                            String nomeProfessor = JOptionPane.showInputDialog("Nome do Professor: ");
                            String cpfProfessor = JOptionPane.showInputDialog("CPF: ");
                            double salarioProf = Double.parseDouble(
                                JOptionPane.showInputDialog("Salario: "));
                            Professor professor = new Professor(nomeProfessor, cpfProfessor, salarioProf);
                            curso.addProf(professor);  
                        }
                    }
                    break;
                case "3":
                    String nomeCursoAluno = JOptionPane.showInputDialog("Informe o nome do Aluno:");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            if(curso.getNomeCurso().equalsIgnoreCase(nomeCursoAluno));
                            encontrado = true;
                            boolean novoAluno = true;
                            do {
                                String nomeAluno = JOptionPane.showInputDialog("Nome do Aluno: ");
                                String cpfAluno = JOptionPane.showInputDialog("CPF: ");
                                String matriculaAluno = JOptionPane.showInputDialog("Matricula: ");
                                curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno));
                                novoAluno = JOptionPane.showInputDialog(
                                    "Inserir novo Aluno? \n"
                                    +"1 - Sim \n"
                                    +"2 - Não").equals("1")?true:false;

                            } while (encontrado);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    cursos = new Curso(nomeCurso);
                    break;
                default:
                    break;
            }
        } while (operacao!="7");
    }
}