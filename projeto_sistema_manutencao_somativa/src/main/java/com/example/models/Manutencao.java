package com.example.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Manutencao{
    private int id;
    private int maquinaId;
    private Date data;
    private String tipo;
    private String pecasTrocadas;
    private int tempoDeParada;
    private int tecnicoId;
    private String observacoes;

    @Override
    public String toString() {
        return "Manutencao{" +
                "id=" + id +
                ", maquinaId=" + maquinaId +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                ", pecasTrocadas='" + pecasTrocadas + '\'' +
                ", tempoDeParada=" + tempoDeParada +
                ", tecnicoId=" + tecnicoId +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}