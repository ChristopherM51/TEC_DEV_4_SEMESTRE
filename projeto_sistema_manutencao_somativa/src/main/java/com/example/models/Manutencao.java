package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Manutencao{
    private String id;
    private String manutencaoId;
    private String data;
    private String tipo;
    private String pecasTrocadas;
    private int tempoDeParada;
    private String tecnicoId;
    private String observacoes;

    @Override
    public String toString() {
        return "Manutencao{" +
                "id=" + id +
                ", manutencaoId=" + manutencaoId +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                ", pecasTrocadas='" + pecasTrocadas + '\'' +
                ", tempoDeParada=" + tempoDeParada +
                ", tecnicoId=" + tecnicoId +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}