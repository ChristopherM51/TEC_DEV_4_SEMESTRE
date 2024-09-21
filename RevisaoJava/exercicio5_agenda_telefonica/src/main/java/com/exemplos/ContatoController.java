package main.java.com.exemplos;

public class ContatoController {
    // Atributos 
    private Contato[] contatos;
    private int contadorDeContatos;

    // Construtor
    public ContatoController(int maxContato) {
        contatos = new Contato[maxContato];
        contadorDeContatos = 0;
    }

    // Métodos - adicionar contato
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contadorDeContatos >= contatos.length) {
            throw new AgendaCheiaException("Agenda cheia");
        }
        contatos[contadorDeContatos] = contato;
        contadorDeContatos++;
        System.out.println("Contato Adicionado");
    }

    // Métodos - Listar Todos
    public void listarContato() {
        if (contadorDeContatos == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }

    // Métodos - Buscar Contato pelo nome
    public void buscarNome(String nome) throws ContatoNaoEncontrado {
        if (contadorDeContatos == 0) {
            System.out.println("Agenda Vazia");
            return; // Retorna para evitar exceção
        }

        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println(contatos[i].toString());
                return; // Contato encontrado, retorna do método
            }
        }
        
        throw new ContatoNaoEncontrado("Contato Não Encontrado");
    }

    // Remover contato
    public void removerContato(String nome) throws ContatoNaoEncontrado {
        boolean encontrado = false;
        for (int i = 0; i<contadorDeContatos; i++){
            if (contatos[i].getNome().equalsIgnoreCase(nome)){
                encontrado = true;
                contatos[i] = contatos[contadorDeContatos - 1];
                contatos[contadorDeContatos -1]=null;
                contadorDeContatos--;
            }
        }if(!encontrado){
            throw new ContatoNaoEncontrado("Contato não encontrado");
        }        
    }
}
