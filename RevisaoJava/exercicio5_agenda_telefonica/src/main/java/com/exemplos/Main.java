package main.java.com.exemplos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("\n-----Agenda de Contatos-----");
            System.out.println("1 - Adicionar Contatos");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Buscar Contato pelo Nome");
            System.out.println("4 - Deletar Contato");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                operacao = sc.nextInt();
                sc.nextLine(); // Consome a nova linha após o próximo inteiro
                
                switch (operacao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        
                        Contato contato = new Contato(nome, email, endereco, telefone);
                        agenda.addContato(contato);
                        break;
                    case 2:
                        agenda.listarContato();
                        break;
                    case 3:
                        System.out.print("Digite o Nome a ser buscado: ");
                        String nomeBuscado = sc.nextLine();
                        agenda.buscarNome(nomeBuscado);
                        break;
                    case 4:
                        try{
                            System.out.println("Digite o Nome a Ser Buscado:");
                            String nomeDeletar = sc.next();
                            agenda.removerContato(nomeDeletar);
                            System.out.println("Contato deletado com sucesso");
                        }catch(Exception e){
                            System.err.println(e);
                    }
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Digite um número válido.");
                        break;
                }
            } catch (AgendaCheiaException e) {
                System.out.println(e.getMessage());
            } catch (ContatoNaoEncontrado e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                sc.nextLine(); // Limpa o buffer do scanner
            }
        } while (operacao != 4);
        
        sc.close();
    }
}
