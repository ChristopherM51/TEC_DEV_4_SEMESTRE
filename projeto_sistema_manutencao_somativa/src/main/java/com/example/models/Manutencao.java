package com.example.models;

import java.sql.Date;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Manutencao{
    private String id;
    private String maquinaId;
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
                ", maquinaId=" + maquinaId +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                ", pecasTrocadas='" + pecasTrocadas + '\'' +
                ", tempoDeParada=" + tempoDeParada +
                ", tecnicoId=" + tecnicoId +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public Collection<?> getManutencao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getManutencao'");
    }
}