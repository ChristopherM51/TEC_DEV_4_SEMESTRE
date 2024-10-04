package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Usuario {
    // Atributos
    private String id;
    private String nome;
    private int idade;
    private String endereco;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereco='" + endereco + '\'' +
                '}';

    }
}
