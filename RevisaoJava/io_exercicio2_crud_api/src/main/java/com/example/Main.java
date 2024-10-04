// package com.example;

// public class Main {
//     public static void main(String[] args) {
//         UsuarioController uc = new UsuarioController();
//         uc.createUser(new Usuario("","Pedro",35,"rua a")); // Adicionando um novo usuário
//         uc.read(); // Lendo os dados de um usuário
//         new UsuarioController().read();
//     }
// }
package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioController uc = new UsuarioController();
        // uc.createUser(new Usuario(
        //     "", 
        //     "Ana", 
        //     45, 
        //     "Rua c"));
        uc.read();
        // uc.updateUser(new Usuario(
        //     "88ad", 
        //     "Ana Clara", 
        //     47, 
        //     "Rua c"));
        uc.deleteUser("88ad");
    }
}