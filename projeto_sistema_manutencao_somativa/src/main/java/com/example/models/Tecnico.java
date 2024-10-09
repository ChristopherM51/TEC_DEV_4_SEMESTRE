package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Tecnico {
    private String id;
    private String nome;
    private String especialidade;
    private String disponibilidade;

    @Override
    public String toString() {
        return "Tecnico{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", disponibilidade='" + disponibilidade + '\'' +
                '}';
    }
}
