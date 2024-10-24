//Maquina.java
package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Maquina {
    private String id;
    private String codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private LocalDate dataAquisicao;
    private long tempoVidaEstimado;
    private String localizacao;
    private String detalhes;
    private String manual;

    @Override
    public String toString() {
        return "Maquina{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", dataAquisicao=" + dataAquisicao +
                ", tempoVidaEstimado=" + tempoVidaEstimado +
                ", localizacao='" + localizacao + '\'' +
                ", observacoes='" + detalhes + '\'' +
                ", manual='" + manual + '\'' +
                '}';
    }
}
